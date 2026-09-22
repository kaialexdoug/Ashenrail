package com.ashenlight.ashenrail;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AshenRail.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // experimental models
        event.registerLayerDefinition(SmallSteamLocomotiveModel.LAYER_LOCATION, SmallSteamLocomotiveModel::createBodyLayer);
        event.registerLayerDefinition(SmallSteamLocomotiveNoRoofModel.LAYER_LOCATION, SmallSteamLocomotiveNoRoofModel::createBodyLayer);
        event.registerLayerDefinition(SmallSteamLocomotiveNoWindowModel.LAYER_LOCATION, SmallSteamLocomotiveNoWindowModel::createBodyLayer);
        event.registerLayerDefinition(SmallOakCarriageModel.LAYER_LOCATION, SmallOakCarriageModel::createBodyLayer);
        event.registerLayerDefinition(SmallOakCarriageNoRoofModel.LAYER_LOCATION, SmallOakCarriageNoRoofModel::createBodyLayer);

        // official models
        event.registerLayerDefinition(SteamLocomotive.LAYER_LOCATION, SteamLocomotive::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TRAIN_CAR.get(), TrainCarRenderer::new);
    }
}
