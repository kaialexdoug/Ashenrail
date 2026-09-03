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

        initializeBreadcrumbs();
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

    public TrainCar getLead() {
        return cars.get(0);
    }

    public TrainCar getRear() {
        return cars.get(cars.size()-1);
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
            initializeBreadcrumbs();
        }
    }

    public void addRear(TrainCar car) {
        if (!cars.contains(car)) {
            cars.add(car);
            car.setAssembly(this);
            initializeBreadcrumbs();
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

    public void initializeBreadcrumbs() {
        if (cars.isEmpty()) return;

        TrainCar leadCar = this.getLead();

        double totalConsistLength = (cars.size() - 1) * TARGET_SPACING;

        leadCar.populateInitialBreadcrumbs(totalConsistLength, 0.25d);
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

    public void tickAssembly() {
        if (cars.size() < 2) return;

        boolean movingForward = isMovingForward();

        TrainCar leadCar = this.getLead();

        for (int i = 1; i < cars.size(); i++) {
            TrainCar follower = cars.get(i);

            double targetDistance = leadCar.getTotalDistanceTraveled() - (i * TARGET_SPACING);

            TrainCar.Breadcrumb targetPoint = leadCar.sampleBreadcrumb(targetDistance);

            if (targetPoint != null) {
                follower.moveTo(
                    targetPoint.position().x,
                    targetPoint.position().y,
                    targetPoint.position().z,
                    follower.getYRot(),
                    follower.getXRot()
                );

                follower.hasImpulse = true;
            }
        }
    }
}


