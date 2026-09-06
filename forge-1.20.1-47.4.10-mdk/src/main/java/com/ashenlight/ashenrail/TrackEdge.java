package com.ashenlight.ashenrail;

import java.util.HashMap;
import java.util.Map;

public class TrackEdge {
    public double length;

    public TrackNode nodeA;
    public TrackNode nodeB;

    private final Map<TrainCar, Double> occupiedCars = new HashMap<>();

    public TrackEdge(TrackNode nodeA, TrackNode nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;

        this.length = nodeA.position.distanceTo(nodeB.position);
    }

    public void addTrainCar(TrainCar car) {
        updateCarPosition(car);
    }

    public void updateCarPosition(TrainCar car) {
        if (car == null) return;
        occupiedCars.put(car, car.getDistanceAlongEdge());
    }
}
