package com.ashenlight.ashenrail;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AshenRail.MODID);

    public static final RegistryObject<EntityType<TrainCar>> TRAIN_CAR = ENTITIES.register("train_car", () -> EntityType.Builder.<TrainCar>of(TrainCar::new, MobCategory.MISC)
            .sized(1.5f, 1.5f)
            .build("train_car"));
}

