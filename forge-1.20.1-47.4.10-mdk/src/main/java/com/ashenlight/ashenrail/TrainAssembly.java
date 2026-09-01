package com.ashenlight.ashenrail;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.*;

import static com.ashenlight.ashenrail.AshenRail.logInGame;
import static com.ashenlight.ashenrail.TrainCar.*;

public class TrainAssembly {
    private final List<TrainCar> cars = new ArrayList<>();

    public TrainAssembly(TrainCar movingCar, TrainCar idleCar) {
        cars.add(movingCar);
        cars.add(idleCar);

        movingCar.setAssembly(this);
        idleCar.setAssembly(this);
    }

    @Override
    public String toString() {
        if (cars.isEmpty()) return "TrainAssembly[Empty]";

        StringBuilder sb = new StringBuilder("TrainAssembly[");
        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i).getId());
            if (i < cars.size()-1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
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

    // syncing movement

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

    public void tickAssembly() {
        if (cars.size() < 2) return;

        for (int i = 1; i < cars.size(); i++) {
            TrainCar leader = cars.get(i-1);
            TrainCar follower = cars.get(i);

            double targetDistance = leader.getTotalDistanceTraveled() - TARGET_SPACING;

            TrainCar.Breadcrumb targetPoint = leader.sampleBreadcrumb(targetDistance);

            if (targetPoint != null && leader.getTotalDistanceTraveled() >= TARGET_SPACING) {
                follower.moveTo(
                    targetPoint.position().x,
                    targetPoint.position().y,
                    targetPoint.position().z,
                    targetPoint.yRot(),
                    targetPoint.xRot()
                );

                follower.hasImpulse = true;
            }
        }

        boolean movingForward = isMovingForward();
    }
}


