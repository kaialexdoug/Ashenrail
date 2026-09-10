package com.ashenlight.ashenrail;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import java.util.HashMap;
import java.util.Map;

public class TrackEdge {
    public double length;

    public TrackNode nodeA;
    public TrackNode nodeB;

    // the block span this edge was built from. TrackEdge instances are never networked,
    // so this is what lets the client rebuild an identical edge from a couple of BlockPos
    // instead of scanning track blocks itself.
    public final BlockPos startPos;
    public final BlockPos endPos;
    public final Direction.Axis axis;

    private final Map<TrainCar, Double> occupiedCars = new HashMap<>();

    public TrackEdge(TrackNode nodeA, TrackNode nodeB, BlockPos startPos, BlockPos endPos, Direction.Axis axis) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;

        this.startPos = startPos.immutable();
        this.endPos = endPos.immutable();
        this.axis = axis;

        this.length = nodeA.position.distanceTo(nodeB.position);
    }

    public void addTrainCar(TrainCar car) {
        updateCarPosition(car);
    }

    public void updateCarPosition(TrainCar car) {
        if (car == null) return;
        occupiedCars.put(car, car.getDistanceAlongEdge());
    }

    public void removeTrainCar(TrainCar car) {
        occupiedCars.remove(car);
    }
}
