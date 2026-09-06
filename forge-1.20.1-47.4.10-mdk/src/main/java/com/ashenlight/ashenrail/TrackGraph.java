package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static com.ashenlight.ashenrail.Debug.logInGame;
import static com.ashenlight.ashenrail.TrackBlock.AXIS;



public class TrackGraph {
    public static Map<BlockPos, TrackEdge> edgesByPos = new HashMap<>();

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

    public static void updateEdgesByPos(BlockPos startPos, BlockPos endPos, Direction.Axis axis, TrackEdge edge) {
        BlockPos current = startPos;
        while (!current.equals(endPos)) {
            edgesByPos.put(current.immutable(), edge);
            current = (axis == Direction.Axis.X) ? current.east() : current.south();
        }
        edgesByPos.put(endPos.immutable(), edge);
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

        // start at startPos

        // cleanupEdges(startPos, endPos);

        TrackEdge edge = new TrackEdge(new TrackNode(nodeALocation), new TrackNode(nodeBLocation));

        updateEdgesByPos(startPos, endPos, axis, edge);

        Debug.debugRenderEdge(level, edge);

        edgesByPos.forEach((logPos, logEdge) -> {
            System.out.println("pos: " + logPos + " -> edge: " + edge);
        });
        // logInGame(level, "Node A: " + edge.nodeA.position + "\nNode B: " + edge.nodeB.position + "\nEdge Length: " + edge.length);
    }

    public static void remove(Level level, BlockPos pos, BlockState state) {
        BlockPos negSide = state.getValue(AXIS) == Direction.Axis.X
                ? pos.east(-1)
                : pos.south(-1);

        BlockPos posSide = state.getValue(AXIS) == Direction.Axis.X
                ? pos.east(1)
                : pos.south(1);

        edgesByPos.remove(pos.immutable());

        BlockState negState = level.getBlockState(negSide);
        if (negState.getBlock() instanceof TrackBlock) {
            path(level, negSide, negState);
        }

        BlockState posState = level.getBlockState(posSide);
        if (posState.getBlock() instanceof TrackBlock) {
            path(level, posSide, posState);
        }
    }
}
