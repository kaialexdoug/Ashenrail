package com.ashenlight.ashenrail.traincarvariants;

import com.ashenlight.ashenrail.OreCarModel;
import com.ashenlight.ashenrail.TrainCar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import static com.ashenlight.ashenrail.AshenRail.ORE_CAR_ITEM;

public class OreCar extends TrainCar {
    public OreCar(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public String getTextureId() {
        return "ore_car";
    }

    @Override
    public String getModelId() {
        return "ore_car";
    }

    @Override
    public Vec3 getSeatOffset() {
        return new Vec3(0.0d, 0.4d, -1.1d);
    }

    @Override
    public double getWheelRadius() {
        return OreCarModel.WHEEL_RADIUS;
    }

    @Override
    public double getCarLength() {
        return 2.2d;
    }

    @Override
    public double getCarWidth() {
        return 1.5d;
    }

    @Override
    public boolean isLocomotive() {
        return false;
    }

    @Override
    public void dropCarItem() {
        ItemStack stackToDrop = new ItemStack(ORE_CAR_ITEM.get());
        this.spawnAtLocation(stackToDrop);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
