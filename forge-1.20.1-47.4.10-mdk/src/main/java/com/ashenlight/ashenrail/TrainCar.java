package com.ashenlight.ashenrail;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import static com.ashenlight.ashenrail.AshenRail.SMALL_OAK_CARRIAGE;
import static com.ashenlight.ashenrail.AshenRail.SMALL_STEAM_LOCOMOTIVE;

public class TrainCar extends Entity {

    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(TrainCar.class, EntityDataSerializers.INT);

    public TrainCar(EntityType<?> type, Level level) {

        super(type, level);
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

    protected AABB makeBoundingBox(double x, double y, double z) {
        float yaw = (this.getYRot() % 360.0f + 360.0f) % 360.0f;
        boolean facingEastWest = (yaw >= 45.0f && yaw < 135.0f) || (yaw >= 225.0f && yaw < 315.0f);

        double halfX = facingEastWest ? 2.0d : 0.75d;
        double halfZ = facingEastWest ? 0.75d : 2.0d;
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

            dropCarItem();
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
            case 0 -> new Vec3(0.0d, 0.3d, -1.0d);
            default -> new Vec3(0.0d, 0.3d, 0.0d);
        };
    }

    @Override
    public void positionRider(Entity passenger, Entity.MoveFunction moveFunction) {
        super.positionRider(passenger, moveFunction);
        if (this.hasPassenger(passenger)) {
            Vec3 offset = getSeatOffsetForVariant(getVariant());

            double yawRad = Math.toRadians(-this.getYRot());
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
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.95d, 1.0d, 0.95d));
    }

//    @Override
//    public void move(MoverType type, Vec3 pos) {
//        if (type == MoverType.SELF) {
//            boolean oldNoPhysics = this.noPhysics;
//            this.noPhysics = true;
//
//            super.move(type, pos);
//
//            this.noPhysics = oldNoPhysics;
//            return;
//        }
//
//        super.move(type,pos);
//    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
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
            this.move(MoverType.SELF, movement);

            this.hasImpulse = true;
        }
    }
}
