package com.ashenlight.ashenrail.traincarvariants;

import com.ashenlight.ashenrail.AshenRail;
import com.ashenlight.ashenrail.Debug;
import com.ashenlight.ashenrail.SteamLocomotiveModel;
import com.ashenlight.ashenrail.TrainCar;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import static com.ashenlight.ashenrail.AshenRail.STEAM_LOCOMOTIVE_ITEM;

public class SteamLocomotive extends TrainCar {
    public SteamLocomotive(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public String getTextureId() {
        return "steam_locomotive";
    }

    @Override
    public String getModelId() {
        return "steam_locomotive";
    }

    @Override
    public Vec3 getSeatOffset() {
        return new Vec3(0.0d, 0.4d, -1.1d);
    }

    @Override
    public double getWheelRadius() {
        return SteamLocomotiveModel.WHEEL_RADIUS;
    }

    @Override
    public double getCarLength() {
        return 3.0d;
    }

    @Override
    public double getCarWidth() {
        return 1.5d;
    }

    @Override
    public boolean isLocomotive() {
        return true;
    }

    @Override
    public void dropCarItem() {
        ItemStack stackToDrop = new ItemStack(STEAM_LOCOMOTIVE_ITEM.get());
        this.spawnAtLocation(stackToDrop);
    }

    // smoke particles

    public void emitSmoke(float yVelocity, float scale) {
        float gray = 0.15f + (float) Math.random() * 0.15f;
        Vector3f color = new Vector3f(gray, gray, gray);

        DustParticleOptions particleOptions = new DustParticleOptions(color, scale);

        double yOffset = 2.5d;
        double zOffset = 1.1d * this.getEdgeAlignment();

        this.level().addParticle(
                particleOptions,
                this.position().x,
                this.position().y + yOffset,
                this.position().z + zOffset,
                0.0d, yVelocity, 0.0d
        );
    }

    @Override
    public void tick() {
        super.tick();

        // smoke emissions
        if (this.entityData.get(THROTTLE) > 0 && this.level().isClientSide) {
            emitSmoke(1.0f, 2.5f);
        }
    }
}
