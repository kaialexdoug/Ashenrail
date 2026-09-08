package com.ashenlight.ashenrail;

import net.minecraft.client.particle.DustParticle;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class Debug {
    // DEBUGGING - methods to help with debugging.

    public static void logInGame(Level level, String message) {
        if (level != null && !level.isClientSide() && level.getServer() != null) {
            level.getServer().getPlayerList().broadcastSystemMessage(
                    Component.literal("[Debug] " + message),
                    false
            );
        }
    }

    public static void renderParticle(Level level, Vec3 position, float r, float g, float b, float scale) {
        Vector3f color = new Vector3f(r, g, b);

        DustParticleOptions particleOptions = new DustParticleOptions(color, scale);

        level.addParticle(
                particleOptions,
                position.x,
                position.y,
                position.z,
                0.0d, 0.0d, 0.0d
        );
    }

    public static void debugRenderEdge(Level level, TrackEdge edge) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        Vec3 start = edge.nodeA.position;
        Vec3 end = edge.nodeB.position;

        DustParticleOptions redNode = new DustParticleOptions(new Vector3f(1.0f, 0.0f, 0.0f), 2.5f);
        DustParticleOptions blueNode = new DustParticleOptions(new Vector3f(0.0f, 0.0f, 1.0f), 2.5f);
        DustParticleOptions greenEdge = new DustParticleOptions(new Vector3f(0.0f, 1.0f, 0.0f), 1.2f);

        // node A (Red)
        serverLevel.sendParticles(redNode, start.x, start.y + 0.2, start.z, 5, 0.05, 0.05, 0.05, 0.0);

        // node B (Blue)
        serverLevel.sendParticles(blueNode, end.x, end.y + 0.2, end.z, 5, 0.05, 0.05, 0.05, 0.0);

        // edge (Green)
        double distance = start.distanceTo(end);
        int steps = Math.max((int) (distance * 4), 2);

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;
            Vec3 pointAlongLine = start.lerp(end, t);

            serverLevel.sendParticles(
                    greenEdge,
                    pointAlongLine.x, pointAlongLine.y + 0.15, pointAlongLine.z,
                    1,
                    0.0, 0.0, 0.0,
                    0.0
            );
        }

    }
}
