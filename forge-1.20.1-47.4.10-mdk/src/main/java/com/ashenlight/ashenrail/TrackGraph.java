package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static com.ashenlight.ashenrail.TrackBlock.AXIS;

public class TrackGraph {
    public TrackGraph() {

    }

    public static Vec3 locateNodeA(Level level, BlockPos pos, BlockState state) {
        Direction.Axis axis = state.getValue(AXIS);
        if (axis == Direction.Axis.X) {
            return new Vec3(pos.getX(), pos.getY(), pos.getZ() + 0.5d);
        } else {
            return new Vec3(pos.getX() + 0.5d, pos.getY(), pos.getZ());
        }
    }

    public static BlockPos getContiguous(Level level, BlockPos pos, BlockState state, int offset) {
        Direction.Axis axis = state.getValue(AXIS);
        if (axis == Direction.Axis.X) {
            return axis == level.getBlockState(new BlockPos(pos.getX() + offset, pos.getY(), pos.getZ())).getValue(AXIS);
        } else {
            return axis == level.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + offset)).getValue(AXIS);
        }
    }

    public static void path(Level level, BlockPos pos, BlockState state) {
        TrackNode nodeA;

        BlockPos contiguousBehind = getContiguous(level, pos, state, -1);
        BlockPos contiguousForward = getContiguous(level, pos, state, 1);

        if (contiguousBehind != null) {
            TrackGraph.path(level, contiguousBehind, state);
        } else if (contiguousForward != null) {
            TrackGraph.path(level, contiguousForward, state);
        } else {
            nodeA = new TrackNode(locateNodeA(level, pos, state));
        }
    }
}
