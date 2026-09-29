package com.ashenlight.ashenrail;

import com.ashenlight.ashenrail.traincarvariants.SteamLocomotive;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AshenRail.MODID);

    public static final RegistryObject<EntityType<SteamLocomotive>> STEAM_LOCOMOTIVE = ENTITIES.register("steam_locomotive", () -> EntityType.Builder.<SteamLocomotive>of(SteamLocomotive::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .build("steam_locomotive"));
}

