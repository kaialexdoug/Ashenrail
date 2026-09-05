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

    public static Vec3 locateNodeA(BlockPos pos, BlockState state) {
        Direction.Axis axis = state.getValue(AXIS);
        if (axis == Direction.Axis.X) {
            return new Vec3(pos.getX(), pos.getY(), pos.getZ() + 0.5d);
        } else {
            return new Vec3(pos.getX() + 0.5d, pos.getY(), pos.getZ());
        }
    }

    public static Vec3 locateNodeB(BlockPos pos, BlockState state) {
        Direction.Axis axis = state.getValue(AXIS);
        if (axis == Direction.Axis.X) {
            return new Vec3(pos.getX() + 1d, pos.getY(), pos.getZ() + 0.5d);
        } else {
            return new Vec3(pos.getX() + 0.5d, pos.getY(), pos.getZ() + 1d);
        }
    }

    public static boolean isContiguous(Level level, BlockPos pos, BlockState state, int offset) {
        Direction.Axis axis = state.getValue(AXIS);

        BlockPos targetPos = (axis == Direction.Axis.X)
                ? pos.east(offset)
                : pos.south(offset);

        BlockState targetState = level.getBlockState(targetPos);
        if (targetState.getBlock() instanceof TrackBlock) {
            return targetState.getValue(AXIS) == axis;
        }
        return false;
    }

    public static void overrideEdgeData(BlockPos pos, BlockState state) {

    }

    public static void path(Level level, BlockPos pos, BlockState state) {
        Direction.Axis axis = state.getValue(AXIS);

        // checking negative direction

        int negOffset = 0;
        while (isContiguous(level, pos, state, negOffset - 1)) {
            negOffset--;
        }

        BlockPos startPos = axis == Direction.Axis.X
                ? pos.east(negOffset)
                : pos.south(negOffset);

        Vec3 nodeALocation = locateNodeA(startPos, state);

        // checking positive direction

        int posOffset = 0;

        while (isContiguous(level, pos, state, posOffset + 1)) {
            posOffset++;
        }

        BlockPos endPos = axis == Direction.Axis.X
                ? pos.east(posOffset)
                : pos.south(posOffset);

        Vec3 nodeBLocation = locateNodeB(endPos, state);

        // create new edge with nodes, but also make sure that leftover edges do not stay
    }
}
