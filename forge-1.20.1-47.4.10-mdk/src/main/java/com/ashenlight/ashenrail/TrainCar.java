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

import static com.ashenlight.ashenrail.AshenRail.*;
import static com.ashenlight.ashenrail.Debug.logInGame;

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

    public static final double DEFAULT_LENGTH = 4.0d;
    public static final double  DEFAULT_WIDTH = 1.5d;

    public static final double COUPLER_GAP = 0.5d;
    public static final double TARGET_SPACING = DEFAULT_LENGTH + COUPLER_GAP;

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

    public boolean isLeadCar() {
        if (this.isAlone()) return false;
        return this.assembly.getCars().get(0) == this;
    }

    public boolean isAlone() {
        return this.getAssembly() == null;
    }

    public boolean isLocomotive() {
        return this.getVariant() == 0;
    }

    // coupling

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

        double thisCenter = isZ ? this.getZ() : this.getX();
        double otherCenter = isZ ? other.getZ() : other.getX();

        double distance = Math.abs(thisCenter - otherCenter);
        double targetCenterDistance = TARGET_SPACING;

        if (distance <= targetCenterDistance + 1.0d) {
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

            // determining lead car
            double thisSpeed = this.getDeltaMovement().lengthSqr();
            double otherSpeed = other.getDeltaMovement().lengthSqr();

            boolean thisHasAssembly = (this.getAssembly() != null);
            boolean otherHasAssembly = (other.getAssembly() != null);

            boolean thisIsAnchor = (thisHasAssembly != otherHasAssembly)
                    ? thisHasAssembly
                    : (thisSpeed != otherSpeed ? thisSpeed > otherSpeed : this.getId() < other.getId());

            if (thisIsAnchor) {

                double sign = (deltaPos >= 0) ? 1.0 : -1.0;

                double newOtherPos = thisCenter + (sign * targetCenterDistance);

                if (isZ) {
                    other.moveTo(this.getX(), other.getY(), newOtherPos, other.getYRot(), other.getXRot());
                } else {
                    other.moveTo(newOtherPos, other.getY(), this.getZ(), other.getYRot(), other.getXRot());
                }
            } else {
                return;
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

            TrainAssembly thisAssembly = this.getAssembly();
            TrainAssembly otherAssembly = other.getAssembly();

            if (thisAssembly == null && otherAssembly == null) { // both this and other are NOT part of a train
                new TrainAssembly(this, other);
                logInGame(this.level(), this.getAssembly().toString());
            } else if (thisAssembly != null && otherAssembly == null) { // only this IS part of a train
                if (thisAssembly.getCars().get(0) == this) {
                    thisAssembly.addFront(other);
                } else {
                    thisAssembly.addRear(other);
                }
                logInGame(this.level(), this.getAssembly().toString());
            } else if (thisAssembly == null) { // only other IS part of a train
                if (otherAssembly.getCars().get(0) == other) {
                    otherAssembly.addFront(this);
                } else {
                    otherAssembly.addRear(this);
                }
                logInGame(this.level(), this.getAssembly().toString());
            } else { // both this and other ARE part of a train
                logInGame(this.level(), this.getAssembly().toString());
                return;
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

    @Override
    public void tick() {
        super.tick();

        this.setBoundingBox(this.makeBoundingBox(this.getX(), this.getY(), this.getZ()));

        // server side running
        if (!this.level().isClientSide()) {
            this.hasImpulse = true;

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
    }
}
