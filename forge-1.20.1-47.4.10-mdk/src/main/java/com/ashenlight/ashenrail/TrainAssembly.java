package com.ashenlight.ashenrail;

import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainAssembly {
    private final List<TrainCar> cars = new ArrayList<>();

    public TrainAssembly(TrainCar movingCar, TrainCar idleCar) {
        cars.add(movingCar);
        cars.add(idleCar);

        movingCar.setAssembly(this);
        idleCar.setAssembly(this);
    }

    public List<TrainCar> getCars() {
        return cars;
    }

    public int getIndex(TrainCar car) {
        return cars.indexOf(car);
    }

    public int size() {
        return cars.size();
    }

    public void addFront(TrainCar car) {
        if (!cars.contains(car)) {
            cars.add(0, car);
            car.setAssembly(this);
        }
    }

    public void addRear(TrainCar car) {
        if (!cars.contains(car)) {
            cars.add(car);
            car.setAssembly(this);
        }
    }

    public void removeCar(TrainCar car) {
        if (!cars.contains(car)) return;

        cars.remove(car);
        car.setAssembly(null);

        if (cars.size() < 2) {
            for (TrainCar remainingCar : cars) {
                remainingCar.setAssembly(null);
            }
            cars.clear();
        }
    }

    public boolean isMovingForward() {
        if (cars.isEmpty()) return true;

        TrainCar head = cars.get(0);
        TrainCar tail = cars.get(cars.size()-1);

        Vec3 movement = head.getDeltaMovement();

        if (movement.lengthSqr() < 0.0001) {
            return true;
        }

        Vec3 posDiff = head.position().subtract(tail.position());

        if (posDiff.lengthSqr() < 0.0001) {
            return true;
        }

        Vec3 assemblyForward = posDiff.normalize();

        return movement.dot(assemblyForward) >= 0;
    }

    public void tickAssembly(double targetSpacing) {
        if (cars.size() < 2) return;

        boolean movingForward = isMovingForward();

        if (movingForward) {
            for (int i = 1; i < cars.size(); i++) {
                TrainCar leader = cars.get(i-1);
                TrainCar follower = cars.get(i);

                TrainCar.Breadcrumb target = leader.getPointAtDistance(targetSpacing);
                follower.setPos(target.pos().x, target.pos().y, target.pos().z);
                follower.setYRot(target.yaw());
            }
        } else {
            for (int i = cars.size() - 2; i >= 0; i--) {
                TrainCar leader = cars.get(i+1);
                TrainCar follower = cars.get(i);

                TrainCar.Breadcrumb target = leader.getPointAtDistance(targetSpacing);
                follower.setPos(target.pos().x, target.pos().y, target.pos().z);
                follower.setYRot(target.yaw());
            }
        }
    }
}


