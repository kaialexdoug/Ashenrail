package com.ashenlight.ashenrail;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkPacket {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AshenRail.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;

    private static int nextPacketId() {
        return packetId++;
    }

    public static void register() {
        CHANNEL.registerMessage(
                nextPacketId(),
                ReverseRequest.class,
                (message, buffer) -> {

                },
                buffer -> new ReverseRequest(),
                (message, context) -> {
                    ServerPlayer player = context.get().getSender();

                    if (player != null) {
                        if (player.getVehicle() instanceof TrainCar trainCar) {
                            trainCar.toggleReversed();
                        }
                    }
                }
        );
    }
}
