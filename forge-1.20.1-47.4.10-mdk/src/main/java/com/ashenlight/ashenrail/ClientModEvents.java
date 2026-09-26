package com.ashenlight.ashenrail;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AshenRail.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // official models
        event.registerLayerDefinition(SteamLocomotiveTest.LAYER_LOCATION, SteamLocomotiveTest::createBodyLayer);
        event.registerLayerDefinition(SteamLocomotiveModel.LAYER_LOCATION, SteamLocomotiveModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TRAIN_CAR.get(), TrainCarRenderer::new);
    }
}
