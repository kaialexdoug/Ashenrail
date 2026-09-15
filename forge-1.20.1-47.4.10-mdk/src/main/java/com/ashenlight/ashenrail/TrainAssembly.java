package com.ashenlight.ashenrail;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.*;

import static com.ashenlight.ashenrail.TrainCar.*;

public class TrainAssembly {
    private final List<TrainCar> cars = new ArrayList<>();

    public double assemblySpeed = 0d;

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

    public TrainCar getLead() {
        return cars.get(0);
    }

    public TrainCar getRear() {
        return cars.get(cars.size()-1);
    }

    // minecraft's tick order appears to be from lower entity id's to higher ones, so we need to get the
    // lowest id car in the assembly in order to determine the coordinator.
    public TrainCar getTickCoordinator() {
        TrainCar coordinator = this.cars.get(0);

        for (TrainCar car : this.cars) {
            if (car.getId() < coordinator.getId()) {
                coordinator = car;
            }
        }

        return coordinator;
    }

    public int getIndex(TrainCar car) {
        return cars.indexOf(car);
    }

    public int size() {
        return cars.size();
    }

    public void prepend(TrainCar car) {
        if (!cars.contains(car)) {
            cars.add(0, car);
            car.setAssembly(this);
        }
    }

    public void append(TrainCar car) {
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

    public void accelerate(double throttle) {
        double alignment = this.getLead().getEdgeAlignment();
        this.assemblySpeed += (throttle * alignment) * TrainCar.ACCELERATION;
        this.assemblySpeed = Math.max(-TrainCar.MAX_SPEED, Math.min(TrainCar.MAX_SPEED, this.assemblySpeed));
    }

    public void applyCoastingFriction() {
        if (this.assemblySpeed != 0) {
            this.assemblySpeed *= TrainCar.FRICTION;
            if (Math.abs(this.assemblySpeed) < 0.01d) {
                this.assemblySpeed = 0.0d;
            }
        }
    }

    public void stopAssembly() {
        this.assemblySpeed = 0.0d;
    }

    public void syncAssemblyMovement(TrainCar car) {
        car.speed = this.assemblySpeed;
    }

    public void tickAssembly() {
        boolean isDriven = false; // assume no player driven locomotive
        for (TrainCar car : this.cars) {
            if (car.isLocomotive() && car.getFirstPassenger() instanceof  Player player) {
                car.processInput(player);
                isDriven = true;
            }
        }

        // if there is no player driven locomotive
        if (!isDriven) {
            applyCoastingFriction();
        }

        // synchronizing the assemblySpeed to all cars.
        for (TrainCar car : this.cars) {
            syncAssemblyMovement(car);
        }
    }
}


