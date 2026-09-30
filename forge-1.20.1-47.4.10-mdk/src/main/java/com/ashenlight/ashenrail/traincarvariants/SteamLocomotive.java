package com.ashenlight.ashenrail.traincarvariants;

import com.ashenlight.ashenrail.SteamLocomotiveModel;
import com.ashenlight.ashenrail.TrainCar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

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
}
