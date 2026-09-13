package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.ashenlight.ashenrail.AshenRail.*;
import static com.ashenlight.ashenrail.Debug.logInGame;
import static com.ashenlight.ashenrail.Debug.renderParticle;

public class TrainCar extends Entity {

    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DISTANCE_ALONG_EDGE = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.FLOAT);

    // TrackEdge itself is never networked. Instead we ship the block span the edge covers,
    // which is exact, tiny, and lets the client rebuild an identical edge with pure math.
    // NOTE: define order matters - these are applied to the client in id order, so the axis
    // must land before the endpoints and EDGE_END must be last (it triggers the rebuild).
    private static final EntityDataAccessor<Integer> EDGE_AXIS = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<BlockPos>> EDGE_START = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.OPTIONAL_BLOCK_POS);
    private static final EntityDataAccessor<Optional<BlockPos>> EDGE_END = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.OPTIONAL_BLOCK_POS);

    private static final int AXIS_X = 0;
    private static final int AXIS_Z = 1;

    private static final Logger log = LoggerFactory.getLogger(TrainCar.class);

    public TrainCar(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(VARIANT, 0);
        this.entityData.define(DISTANCE_ALONG_EDGE, 0.0f);
        this.entityData.define(EDGE_AXIS, AXIS_X);
        this.entityData.define(EDGE_START, Optional.empty());
        this.entityData.define(EDGE_END, Optional.empty());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.contains("Variant")) {
            int savedVariant = compoundTag.getInt("Variant");
            setVariant(savedVariant);
        }

        // TrackGraph.edgesByPos is rebuilt from block placements only, so it is empty after a
        // world reload. Rebuild this car's edge from its own saved span instead of relying on it.
        if (compoundTag.contains("EdgeStart") && compoundTag.contains("EdgeEnd")) {
            BlockPos start = NbtUtils.readBlockPos(compoundTag.getCompound("EdgeStart"));
            BlockPos end = NbtUtils.readBlockPos(compoundTag.getCompound("EdgeEnd"));
            Direction.Axis axis = compoundTag.getInt("EdgeAxis") == AXIS_X ? Direction.Axis.X : Direction.Axis.Z;

            TrackEdge known = TrackGraph.edgesByPos.get(start);
            this.currentEdge = (known != null) ? known : buildEdge(start, end, axis);

            this.distanceAlongEdge = compoundTag.getDouble("DistanceAlongEdge");
            this.prevDistanceAlongEdge = this.distanceAlongEdge;

            this.currentEdge.addTrainCar(this);
            publishEdgeToClients();
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("Variant", getVariant());

        if (this.currentEdge != null) {
            compoundTag.put("EdgeStart", NbtUtils.writeBlockPos(this.currentEdge.startPos));
            compoundTag.put("EdgeEnd", NbtUtils.writeBlockPos(this.currentEdge.endPos));
            compoundTag.putInt("EdgeAxis", this.currentEdge.axis == Direction.Axis.X ? AXIS_X : AXIS_Z);
            compoundTag.putDouble("DistanceAlongEdge", this.distanceAlongEdge);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void setYRot(float yRot) {
        super.setYRot(yRot);
        this.setBoundingBox(this.makeBoundingBox(this.getX(), this.getY(), this.getZ()));
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        }

        if (!this.level().isClientSide && !this.isRemoved()) {
            this.discard();

            if (!source.isCreativePlayer()) dropCarItem();
        }

        return true;
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        }

        boolean isClientSide = this.level().isClientSide;

        if (!isClientSide) {
            if (player.startRiding(this)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

        return InteractionResult.SUCCESS;
    }

    // VARIANT RELATED STUFF

    private Vec3 getSeatOffsetForVariant(int variant) {
        return switch(variant) {
            case 0 -> new Vec3(0.0d, 0.5d, -1.0d);
            default -> new Vec3(0.0d, 0.5d, 0.0d);
        };
    }

    public static final double DEFAULT_LENGTH = 4.0d;
    public static final double  DEFAULT_WIDTH = 1.5d;

    public double getCarLength() {
        return switch (this.getVariant()) {
            case 0 -> 4.0d;
            case 1 -> 4.0d;
            default -> DEFAULT_LENGTH;
        };
    }

    public double getCarWidth() {
        return switch (this.getVariant()) {
            case 0 -> 1.5d;
            case 1 -> 1.5d;
            default -> DEFAULT_WIDTH;
        };
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int newVariant) {
        this.entityData.set(VARIANT, newVariant);
    }

    public boolean isLocomotive() {
        return this.getVariant() == 0;
    }

    @Override
    public void positionRider(Entity passenger, Entity.MoveFunction moveFunction) {
        // called once per tick from Entity.rideTick(), never from the renderer - the passenger
        // gets its own xOld -> x frame interpolation exactly like the car does.
        if (this.hasPassenger(passenger)) {
            Vec3 offset = getSeatOffsetForVariant(getVariant());

            double yawRad = Math.toRadians(this.getYRot());
            double rotatedX = offset.x * Math.cos(yawRad) - offset.z * Math.sin(yawRad);
            double rotatedZ = offset.x * Math.sin(yawRad) + offset.z * Math.cos(yawRad);

            double x = this.getX() + rotatedX;
            double y = this.getY() + offset.y;
            double z = this.getZ() + rotatedZ;

            moveFunction.accept(passenger, x, y, z);
        }
    }

    private void dropCarItem() {
        ItemStack stackToDrop;
        switch (getVariant()) {
            case 0 -> stackToDrop = new ItemStack(SMALL_STEAM_LOCOMOTIVE.get());
            default -> stackToDrop = new ItemStack(SMALL_OAK_CARRIAGE.get());
        }
        this.spawnAtLocation(stackToDrop);
    }

    protected AABB makeBoundingBox(double x, double y, double z) {
        float yaw = (this.getYRot() % 360.0f + 360.0f) % 360.0f;
        boolean facingEastWest = (yaw >= 45.0f && yaw < 135.0f) || (yaw >= 225.0f && yaw < 315.0f);

        double halfX = facingEastWest ? this.getCarLength() / 2.0d : this.getCarWidth() / 2.0d;
        double halfZ = facingEastWest ? this.getCarWidth() / 2.0d : this.getCarLength() / 2.0d;
        double height = 2.0d;

        double yOffset = 0.625d;

        return new AABB(
                x - halfX, y + yOffset, z - halfZ,
                x + halfX, y + yOffset + height, z + halfZ
        );
    }

    // coupling

    public static final double COUPLER_GAP = 0.5d;

    private TrainCar frontCoupledCar = null;
    private TrainCar rearCoupledCar = null;

    public Direction.Axis getTrackAxis() {
        float yaw = (this.getYRot() % 360.0f + 360.0f) % 360.0f;
        boolean eastWest = (yaw >= 45.0f && yaw < 135.0f) || (yaw >= 225.0f && yaw < 315.0f);
        return eastWest ? Direction.Axis.X : Direction.Axis.Z;
    }

    public boolean isAlignedWith(TrainCar other) {
        double tolerance = 0.3d;

        if (this.getTrackAxis() != other.getTrackAxis() || Math.abs(this.getY() - other.getY()) > tolerance) {
            return false;
        }

        if (this.getTrackAxis() == Direction.Axis.Z) {
            return Math.abs(this.getX() - other.getX()) < tolerance;
        } else {
            return Math.abs(this.getZ() - other.getZ()) < tolerance;
        }
    }

    public boolean hasOpenCoupler() {
        return this.frontCoupledCar == null || this.rearCoupledCar == null;
    }

    public TrainCar getFrontCoupledCar() { return frontCoupledCar; }
    public TrainCar getRearCoupledCar() { return rearCoupledCar; }

    public void setFrontCoupledCar(TrainCar car) { this.frontCoupledCar = car; }
    public void setRearCoupledCar(TrainCar car) { this.rearCoupledCar = car; }

    public void tryCoupleWith(TrainCar other) {
        if (other == this || !this.isAlignedWith(other)) return;
        if (!this.hasOpenCoupler() || !other.hasOpenCoupler()) return;

        Direction.Axis axis = this.getTrackAxis();
        boolean isZ = (axis == Direction.Axis.Z);

        TrainCar anchor = determineAnchor(other);
        boolean thisIsAnchor = anchor == this;
        TrainCar nonAnchor = (thisIsAnchor) ? other : this;

        double distance = this.position().distanceTo(other.position());
        double targetCenterDistance = (this.getCarLength() / 2.0d) + (other.getCarLength() / 2.0d) + COUPLER_GAP;

        if (distance <= targetCenterDistance + 1.0d && thisIsAnchor) {

            boolean nonAnchorFurther = nonAnchor.getDistanceAlongEdge() >= anchor.getDistanceAlongEdge();

            double offset = nonAnchorFurther ? targetCenterDistance : -targetCenterDistance;

            // determining if coupled to front or back for both cars
            if (!canCouple(nonAnchorFurther, anchor, nonAnchor)) {
                return; // abort because slots are occupied.
            }

            connectCouplers(nonAnchorFurther, anchor, nonAnchor);

            // setting the position of nonAnchor and matching its speed too
            double newDistance = anchor.getDistanceAlongEdge() + offset;

            nonAnchor.setDistanceAlongEdge(newDistance);
            nonAnchor.speed = anchor.speed;

            // integrating Train Assembly
            reconcileAssembly(anchor, nonAnchor);
        }
    }

    public static void reconcileAssembly(TrainCar anchor, TrainCar nonAnchor) {
        // 3 cases
        if (anchor.isAlone() && nonAnchor.isAlone()) { // both anchor and nonanchor are NOT part of a train
            new TrainAssembly(anchor, nonAnchor);
            logInGame(anchor.level(), anchor.getAssembly().toString());
        } else if (!anchor.isAlone() && nonAnchor.isAlone()) { // only anchor IS part of a train
            if (anchor.getAssembly().getCars().get(0) == anchor) {
                anchor.getAssembly().prepend(nonAnchor);
            } else {
                anchor.getAssembly().append(nonAnchor);
            }
            logInGame(anchor.level(), anchor.getAssembly().toString());
        } else if (!anchor.isAlone() && !nonAnchor.isAlone()) { // both anchor and nonanchor ARE part of a train

        }
    }

    public static boolean canCouple(boolean nonAnchorFurther, TrainCar anchor, TrainCar nonAnchor) {
        boolean anchorTouchesFront = (nonAnchorFurther == anchor.isFacingNodeB());
        boolean nonAnchorTouchesFront = (!nonAnchorFurther == nonAnchor.isFacingNodeB());

        TrainCar anchorTargetSlot = anchorTouchesFront ? anchor.getFrontCoupledCar() : anchor.getRearCoupledCar();
        TrainCar nonAnchorTargetSlot = nonAnchorTouchesFront ? nonAnchor.getFrontCoupledCar() : nonAnchor.getRearCoupledCar();

        return anchorTargetSlot == null && nonAnchorTargetSlot == null;
    }

    public static void connectCouplers(boolean nonAnchorFurther, TrainCar anchor, TrainCar nonAnchor) {
        boolean anchorTouchesFront = (nonAnchorFurther == anchor.isFacingNodeB());
        boolean nonAnchorTouchesFront = (!nonAnchorFurther == nonAnchor.isFacingNodeB());

        updateFrontRearCoupling(anchorTouchesFront, anchor, nonAnchor);
        updateFrontRearCoupling(nonAnchorTouchesFront, nonAnchor, anchor);
    }

    public static void updateFrontRearCoupling(boolean carTouchesFront, TrainCar car, TrainCar otherCar) {
        if (carTouchesFront) {
            car.setFrontCoupledCar(otherCar);
        } else {
            car.setRearCoupledCar(otherCar);
        }
    }

    public TrainCar determineAnchor(TrainCar other) {
        double thisAbsSpeed = this.getAbsSpeed();
        double otherAbsSpeed = other.getAbsSpeed();

        boolean thisIsAnchor = (this.isAlone() != other.isAlone())
                ? !this.isAlone()
                : (thisAbsSpeed != otherAbsSpeed) ? thisAbsSpeed > otherAbsSpeed : this.getId() < other.getId();

        return thisIsAnchor ? this : other;
    }

    public void uncoupleAll() {
        if (this.frontCoupledCar != null) {
            this.frontCoupledCar.uncouple(this);
            this.frontCoupledCar = null;
        }
        if (this.rearCoupledCar != null) {
            this.rearCoupledCar.uncouple(this);
            this.rearCoupledCar = null;
        }
    }

    public void uncouple(TrainCar car) {
        if (this.frontCoupledCar == car) {
            this.frontCoupledCar = null;
        }
        if (this.rearCoupledCar == car) {
            this.rearCoupledCar = null;
        }
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        this.uncoupleAll();

        if (this.currentEdge != null) {
            this.currentEdge.removeTrainCar(this);
        }

        if (this.assembly != null) {
            this.assembly.removeCar(this);
        }

        super.remove(reason);
    }

    // train assembly

    private TrainAssembly assembly = null;

    public TrainAssembly getAssembly() {
        return this.assembly;
    }

    public void setAssembly(TrainAssembly assembly) {
        this.assembly = assembly;
    }

    public boolean isAlone() {
        return this.getAssembly() == null;
    }

    public boolean isLeadCar() {
        if (this.isAlone()) return false;
        return this.assembly.getLead() == this;
    }

    public boolean isRearCar() {
        if (this.isAlone()) return false;
        return this.assembly.getRear() == this;
    }

    public TrainCar getNext() {
        if (this.isAlone() || this.isRearCar()) return null;
        return this.assembly.getCars().get(this.assembly.getIndex(this) + 1);
    }

    public TrainCar getPrev() {
        if (this.isAlone() || this.isLeadCar()) return null;
        return this.assembly.getCars().get(this.assembly.getIndex(this) - 1);
    }

    // node system integration

    private TrackEdge currentEdge;
    private double distanceAlongEdge;
    private double prevDistanceAlongEdge;

    public boolean onEdge() {
        return this.currentEdge != null;
    }

    public void spawnOnEdge(TrackEdge edge, Vec3 spawnPos, float yaw) {
        if (edge == null) return;

        this.currentEdge = edge;

        // project onto the edge rather than measuring straight-line distance to node A, so the
        // block-centre spawn offset (and the 1/16 y nudge) doesn't leak into the distance.
        Vec3 direction = edge.nodeB.position.subtract(edge.nodeA.position).normalize();
        this.distanceAlongEdge = Mth.clamp(
                spawnPos.subtract(edge.nodeA.position).dot(direction), 0.0d, edge.length);
        this.prevDistanceAlongEdge = this.distanceAlongEdge;

        this.setYRot(yaw);
        this.yRotO = yaw;
        this.setXRot(0.0f);
        this.xRotO = 0.0f;

        this.currentEdge.addTrainCar(this);
        setPositionFromEdge();

        publishEdgeToClients();
    }

    public boolean isFacingNodeB() {
        if (this.currentEdge == null) {
            return false;
        }

        Vec3 nodeAPos = this.currentEdge.nodeA.position;
        Vec3 nodeBPos = this.currentEdge.nodeB.position;
        Vec3 edgeDir = nodeBPos.subtract(nodeAPos).normalize();

        float yawRad = (float) Math.toRadians(this.getYRot());
        Vec3 carForwardDir = new Vec3(-Math.sin(yawRad), 0.0d, Math.cos(yawRad));

        return carForwardDir.dot(edgeDir) > 0.0d;
    }

    // ---- client-side edge resolution ---------------------------------------------------
    //
    // The client can't share the server's TrackEdge instances, so it is handed the edge's
    // block span and rebuilds an equal one locally. This is pure arithmetic on two BlockPos:
    // no level access, no isContiguous() scan, nothing that scales with segment length.

    private static TrackEdge buildEdge(BlockPos start, BlockPos end, Direction.Axis axis) {
        return new TrackEdge(
                new TrackNode(TrackGraph.locateNodeA(start, axis)),
                new TrackNode(TrackGraph.locateNodeB(end, axis)),
                start,
                end,
                axis
        );
    }

    private void publishEdgeToClients() {
        if (this.currentEdge == null) return;

        this.entityData.set(EDGE_AXIS, this.currentEdge.axis == Direction.Axis.X ? AXIS_X : AXIS_Z);
        this.entityData.set(EDGE_START, Optional.of(this.currentEdge.startPos));
        this.entityData.set(EDGE_END, Optional.of(this.currentEdge.endPos));
        this.entityData.set(DISTANCE_ALONG_EDGE, (float) this.distanceAlongEdge);
    }

    private void rebuildEdgeFromSyncedData() {
        Optional<BlockPos> start = this.entityData.get(EDGE_START);
        Optional<BlockPos> end = this.entityData.get(EDGE_END);

        if (start.isEmpty() || end.isEmpty()) {
            this.currentEdge = null;
            return;
        }

        Direction.Axis axis = this.entityData.get(EDGE_AXIS) == AXIS_X ? Direction.Axis.X : Direction.Axis.Z;
        this.currentEdge = buildEdge(start.get(), end.get(), axis);

        // land on the exact edge position immediately, and clear the interpolation history so
        // the first rendered frame doesn't slide in from wherever the spawn packet put us.
        this.distanceAlongEdge = this.entityData.get(DISTANCE_ALONG_EDGE);
        this.prevDistanceAlongEdge = this.distanceAlongEdge;
        setPositionFromEdge();
        this.setOldPosAndRot();
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);

        if (!this.level().isClientSide) return;

        if (EDGE_START.equals(key) || EDGE_END.equals(key) || EDGE_AXIS.equals(key)) {
            rebuildEdgeFromSyncedData();
        }
    }

    @Override
    public void lerpTo(double x, double y, double z, float yaw, float pitch, int steps, boolean teleport) {
        // Entity's default lerpTo is a hard snap to the last position packet (only LivingEntity
        // actually interpolates), and those packets land between ticks, every updateInterval
        // ticks. That snap is what causes the rubberbanding: it fights the position we derive
        // from the edge and wrecks the renderer's xOld -> x lerp. The edge is authoritative
        // whenever we have one; fall back to vanilla behaviour only if we somehow don't.
        if (this.currentEdge == null) {
            this.setPos(x, y, z);
        }

        this.setYRot(yaw);
        this.setXRot(pitch);
    }

    public void setPositionFromEdge() {
        setPositionFromEdge(this.distanceAlongEdge);
    }

    public void setPositionFromEdge(double distance) {
        if (this.currentEdge == null) return;

        Vec3 start = this.currentEdge.nodeA.position;
        Vec3 end = this.currentEdge.nodeB.position;

        double totalLength = this.currentEdge.length;
        double t = totalLength > 0 ? (distance / totalLength) : 0.0;
        t = Math.max(0.0, Math.min(1.0, t));

        Vec3 targetPos = start.lerp(end, t);

        this.setPos(targetPos.x, targetPos.y, targetPos.z);

        this.setBoundingBox(this.makeBoundingBox(this.getX(), this.getY(), this.getZ()));
    }

    public double getDistanceAlongEdge() {
        return this.distanceAlongEdge;
    }

    public void setDistanceAlongEdge(double newDistance) {
        this.distanceAlongEdge = newDistance;
    }

    // ensuring the train car travels in the right direction
    public double getEdgeAlignment() {
        if (this.currentEdge == null) return 1.0;

        Vec3 edgeVector = this.currentEdge.nodeB.position
                .subtract(this.currentEdge.nodeA.position)
                .normalize();

        Vec3 forwardVector = this.getLookAngle();

        double dot = edgeVector.dot(forwardVector);

        return (dot >= 0) ? 1.0 : -1.0;
    }

    // movement

    public static final double MAX_SPEED = 0.4f;
    public static final double ACCELERATION = 0.01d;
    public double speed = 0.0d;

    public void accelerate(double throttle) {
        double alignment = getEdgeAlignment();
        this.speed += (throttle * alignment) * ACCELERATION;
        this.speed = Math.max(-MAX_SPEED, Math.min(MAX_SPEED, this.speed));
    }

    public static final double FRICTION = 0.98d;

    public void applyCoastingFriction() {
        if (this.speed != 0) {
            this.speed *= FRICTION;
            if (Math.abs(this.speed) < 0.01d) {
                this.speed = 0.0d;
            }
        }
    }

    public double getAbsSpeed() {
        return Math.abs(this.speed);
    }

    public void processInput(Player player) {
        float forwardInput = player.zza;

        if (!this.isAlone()) {
            if (forwardInput > 0) this.assembly.accelerate(1);
            else if (forwardInput < 0) this.assembly.accelerate(-1);
            else this.assembly.applyCoastingFriction();
        } else {
            if (forwardInput > 0) accelerate(1);
            else if (forwardInput < 0) accelerate(-1);
            else applyCoastingFriction();
        }
    }

    public void updatePosition() {
        this.prevDistanceAlongEdge = this.distanceAlongEdge;

        // clamp the distance itself, not just the rendered position. Letting it run past the
        // end of the edge leaves the car pinned at the node while the counter keeps climbing,
        // so reversing does nothing until it has wound all the way back down.
        this.distanceAlongEdge = Mth.clamp(this.distanceAlongEdge + this.speed, 0.0d, this.currentEdge.length);
        if (this.distanceAlongEdge <= 0.0d || this.distanceAlongEdge >= this.currentEdge.length) {
            this.speed = 0.0d;
        }

        this.entityData.set(DISTANCE_ALONG_EDGE, (float) this.distanceAlongEdge);

        this.currentEdge.updateCarPosition(this);
        setPositionFromEdge();
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            // SERVER SIDE
            if (this.onEdge()) {
                // movement
                if (this.isAlone()) {
                    if (this.isLocomotive() && this.getFirstPassenger() instanceof Player player) {
                        processInput(player);
                    } else {
                        applyCoastingFriction();
                    }
                } else if (this.isLeadCar()) {
                    this.assembly.tickAssembly();
                }

                // updating position to the server
                updatePosition();

                // coupling listener
                if (this.hasOpenCoupler()) {
                    AABB searchBox = this.getBoundingBox().inflate(1.5d);
                    List<TrainCar> nearbyCars = this.level().getEntitiesOfClass(TrainCar.class, searchBox);

                    for (TrainCar nearbyCar : nearbyCars) {
                        if (nearbyCar != this && (this.getAssembly() == null || this.getAssembly() != nearbyCar.getAssembly()) && nearbyCar.hasOpenCoupler()) {
                            this.tryCoupleWith(nearbyCar);
                        }
                    }
                }
            }

        } else {
            // CLIENT SIDE
            // The server sends DISTANCE_ALONG_EDGE every tick it changes (SynchedEntityData is
            // flushed whenever it's dirty). Turn that into a world position exactly ONCE per
            // tick, here - ClientLevel calls setOldPosAndRot() immediately before tick(), so
            // the renderer gets a free, correct xOld -> x lerp across the frames in between.
            // Never do this from the renderer: render() runs after the frame transform is
            // computed and many times per tick, which is what caused the flickering.
            if (this.currentEdge == null) {
                rebuildEdgeFromSyncedData();
            }

            this.prevDistanceAlongEdge = this.distanceAlongEdge;
            this.distanceAlongEdge = this.entityData.get(DISTANCE_ALONG_EDGE);

            if (this.currentEdge != null) {
                setPositionFromEdge();
            }
        }
    }
}
