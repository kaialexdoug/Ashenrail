package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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

import java.util.List;

import static com.ashenlight.ashenrail.AshenRail.SMALL_OAK_CARRIAGE;
import static com.ashenlight.ashenrail.AshenRail.SMALL_STEAM_LOCOMOTIVE;

public class TrainCar extends Entity {

    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.INT);
    private static final Logger log = LoggerFactory.getLogger(TrainCar.class);

    public TrainCar(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(VARIANT, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.contains("Variant")) {
            int savedVariant = compoundTag.getInt("Variant");
            setVariant(savedVariant);
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("Variant", getVariant());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private static final double DEFAULT_LENGTH = 4.0d;
    private static final double  DEFAULT_WIDTH = 1.5d;

    protected AABB makeBoundingBox(double x, double y, double z) {
        float yaw = (this.getYRot() % 360.0f + 360.0f) % 360.0f;
        boolean facingEastWest = (yaw >= 45.0f && yaw < 135.0f) || (yaw >= 225.0f && yaw < 315.0f);

        double halfX = facingEastWest ? DEFAULT_LENGTH / 2.0d : DEFAULT_WIDTH / 2.0d;
        double halfZ = facingEastWest ? DEFAULT_WIDTH / 2.0d : DEFAULT_LENGTH / 2.0d;
        double height = 2.0d;

        double yOffset = 0.625d;

        return new AABB(
                x - halfX, y + yOffset, z - halfZ,
                x + halfX, y + yOffset + height, z + halfZ
        );
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

    private Vec3 getSeatOffsetForVariant(int variant) {
        return switch(variant) {
            case 0 -> new Vec3(0.0d, 0.5d, -1.0d);
            default -> new Vec3(0.0d, 0.5d, 0.0d);
        };
    }

    @Override
    public void positionRider(Entity passenger, Entity.MoveFunction moveFunction) {
        super.positionRider(passenger, moveFunction);
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

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int newVariant) {
        this.entityData.set(VARIANT, newVariant);
    }

    // coupling

    private TrainCar frontCoupledCar = null;
    private TrainCar rearCoupledCar = null;

    public static final double COUPLER_GAP = 0.5d;

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

        double thisCenter = isZ ? this.getZ() : this.getX();
        double otherCenter = isZ ? other.getZ() : other.getX();

        double distance = Math.abs(thisCenter - otherCenter);
        double targetCenterDistance = DEFAULT_LENGTH + COUPLER_GAP;

        if (Math.abs(distance - targetCenterDistance) <= 1.0d) {
            double deltaPos = otherCenter - thisCenter;
            float yawRad = (float) Math.toRadians(this.getYRot());
            double forwardDir = isZ ? Math.cos(yawRad) : -Math.sin(yawRad);
            boolean thisTouchesFront = (deltaPos * forwardDir) > 0;

            double otherDeltaPos = thisCenter - otherCenter;
            float otherYawRad = (float) Math.toRadians(other.getYRot());
            double otherForwardDir = isZ ? Math.cos(otherYawRad) : -Math.sin(otherYawRad);
            boolean otherTouchesFront = (otherDeltaPos * otherForwardDir) > 0;

            TrainCar thisTargetSlot = thisTouchesFront ? this.frontCoupledCar : this.rearCoupledCar;
            TrainCar otherTargetSlot = otherTouchesFront ? other.frontCoupledCar : other.rearCoupledCar;

            if (thisTargetSlot != null || otherTargetSlot != null) {
                return;
            }

            double newPosOnAxis = thisCenter > otherCenter
                    ? otherCenter + targetCenterDistance
                    : otherCenter - targetCenterDistance;

            if (isZ) {
                this.setPos(other.getX(), other.getY(), newPosOnAxis);
                this.setBoundingBox(this.makeBoundingBox(other.getX(), other.getY(), newPosOnAxis));
                System.out.println("COUPLED!");
            } else {
                this.setPos(newPosOnAxis, other.getY(), other.getZ());
                this.setBoundingBox(this.makeBoundingBox(newPosOnAxis, other.getY(), other.getZ()));
                System.out.println("COUPLED!");
            }

            if (thisTouchesFront) {
                this.setFrontCoupledCar(other);
            } else {
                this.setRearCoupledCar(other);
            }

            if (otherTouchesFront) {
                other.setFrontCoupledCar(this);
            } else {
                other.setRearCoupledCar(this);
            }
        }
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

        super.remove(reason);
    }

    // movement

    private boolean isOnTrack(double x, double y, double z) {
        BlockPos checkPos = BlockPos.containing(x, y, z);
        BlockState state = this.level().getBlockState(checkPos);

        float yaw = (this.getYRot() % 360.0f + 360.0f) % 360.0f;
        boolean trainIsEastWest = (yaw >= 45.0f && yaw < 135.0f) || (yaw >= 225.0f && yaw < 315.0f);
        Direction.Axis trainAxis = trainIsEastWest ? Direction.Axis.X : Direction.Axis.Z;

        if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) && state.getBlock() instanceof TrackBlock) {
            Direction.Axis trackAxis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            return trackAxis == trainAxis;
        }

        return false;
    }

    private boolean canMoveInDirection(Vec3 delta) {
        if (delta.lengthSqr() < 1.0E-6d) {
            return true;
        }

        double lookAheadDistance = 2.0;
        Vec3 moveDir = delta.normalize();

        double testX = this.getX() + (moveDir.x * lookAheadDistance);
        double testZ = this.getZ() + (moveDir.z * lookAheadDistance);

        if (Math.abs(delta.x) > 0.001) {
            if (!isOnTrack(testX, this.getY(), this.getZ())) {
                return false;
            }
        }

        if (Math.abs(delta.z) > 0.001) {
            if (!isOnTrack(this.getX(), this.getY(), testZ)) {
                return false;
            }
        }

        return true;
    }

    private static final double ACCELERATION = 0.01d;
    private static final double MAX_SPEED = 0.4d;

    private void accelerate(boolean reversed) {
        int directionFactor = reversed ? -1 : 1;
        Vec3 lookVec = this.getLookAngle();
        Vec3 currentDeltaMovement = this.getDeltaMovement();

        if (currentDeltaMovement.length() < MAX_SPEED) {
            this.setDeltaMovement(currentDeltaMovement.add(
                    lookVec.x * ACCELERATION * directionFactor,
                    0.0D,
                    lookVec.z * ACCELERATION * directionFactor));
        }
    }

    private void applyCoastingFriction() {
        Vec3 current = this.getDeltaMovement();

        double horizontalSpeedSq = current.x * current.x + current.z * current.z;

        double stopThresholdSq = 0.0001d;

        if (horizontalSpeedSq < stopThresholdSq) {
            this.setDeltaMovement(0.0d, current.y, 0.0d);
            return;
        }

        double multiplier = 0.98d;
        this.setDeltaMovement(current.x * multiplier, current.y, current.z * multiplier);
    }

    @Override
    public void tick() {
        super.tick();
        // only variant 0 (steam loco) responds to player drive inputs.
        if (this.getVariant() == 0 && this.getFirstPassenger() instanceof Player player) {
            float forwardInput = player.zza;
            if (forwardInput > 0.0f) {
                accelerate(false);
            } else if (forwardInput < 0.0f) {
                accelerate(true);
            } else {
                applyCoastingFriction();
            }
        } else {
            applyCoastingFriction();
        }

        Vec3 movement = this.getDeltaMovement();

        if (!canMoveInDirection(movement)) {
            movement = Vec3.ZERO;
            this.setDeltaMovement(Vec3.ZERO);
        }

        this.move(MoverType.SELF, movement);

        this.setBoundingBox(this.makeBoundingBox(this.getX(), this.getY(), this.getZ()));

        // coupling listener
        if (this.hasOpenCoupler()) {
            AABB searchBox = this.getBoundingBox().inflate(1.5d);
            List<TrainCar> nearbyCars = this.level().getEntitiesOfClass(TrainCar.class, searchBox);

            for (TrainCar nearbyCar : nearbyCars) {
                if (nearbyCar != this && nearbyCar.hasOpenCoupler()) {
                    this.tryCoupleWith(nearbyCar);
                }
            }
        }

        if (!this.level().isClientSide()) {
            this.hasImpulse = true;
        }
    }
}
