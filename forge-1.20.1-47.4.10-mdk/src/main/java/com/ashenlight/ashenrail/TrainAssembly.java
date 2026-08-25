package com.ashenlight.ashenrail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainAssembly {
    private List<TrainCar> cars;
    private double assemblyVelocity = 0.0d;

    public TrainAssembly(List<TrainCar> cars) {
        if (cars != null) {
            this.cars = new ArrayList<>(cars);
        }
    }

    public void addCar(TrainCar car) {
        if (!cars.contains(car)) {
            this.cars.add(car);
        }
    }

    public List<TrainCar> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public TrainCar getLeadCar() {
        return this.cars.isEmpty() ? null : this.cars.get(0);
    }
}
