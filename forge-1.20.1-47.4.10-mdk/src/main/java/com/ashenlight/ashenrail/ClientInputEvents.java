package com.ashenlight.ashenrail;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.ashenlight.ashenrail.ClientModEvents.REVERSE_KEY;

@Mod.EventBusSubscriber(
        modid = AshenRail.MODID,
        bus = Mod.EventBusSubscriber.Bus.FORGE,
        value = Dist.CLIENT
)
public class ClientInputEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (REVERSE_KEY.consumeClick()) {
                Minecraft minecraft = Minecraft.getInstance();
                Player player = minecraft.player;

                if (player != null) {
                    if (player.getVehicle() instanceof TrainCar trainCar) {
                        trainCar.toggleReversed();
                    }
                }
            }
        }
    }
}
