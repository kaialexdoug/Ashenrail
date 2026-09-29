package com.ashenlight.ashenrail.traincarvariants;

import com.ashenlight.ashenrail.TrainCar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SteamLocomotive extends TrainCar {
    public SteamLocomotive(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isLocomotive() {
        return true;
    }

    @Override
    public String getTextureId() {
        return "steam_locomotive";
    }

    @Override
    public String getModelId() {
        return "steam_locomotive";
    }

}
