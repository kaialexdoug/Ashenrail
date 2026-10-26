package com.ashenlight.ashenrail;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;

@Mod.EventBusSubscriber(modid = AshenRail.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    public static final KeyMapping REVERSE_KEY = new KeyMapping(
            "key.ashenrail.reverse",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_R,
            "key.categories.ashenrail"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(REVERSE_KEY);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // official models
        event.registerLayerDefinition(SteamLocomotiveTest.LAYER_LOCATION, SteamLocomotiveTest::createBodyLayer);
        event.registerLayerDefinition(SteamLocomotiveModel.LAYER_LOCATION, SteamLocomotiveModel::createBodyLayer);
        event.registerLayerDefinition(OreCarModel.LAYER_LOCATION, OreCarModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.STEAM_LOCOMOTIVE.get(), TrainCarRenderer::new);
        event.registerEntityRenderer(ModEntities.ORE_CAR.get(), TrainCarRenderer::new);
    }
}
