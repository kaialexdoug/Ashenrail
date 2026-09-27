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

    // Ordered front to rear - index 0 is the lead car. Callers build that order; the assembly
    // does not try to infer it, because "front" is about how the cars face, not where they sit
    // on the edge.
    public TrainAssembly(List<TrainCar> orderedCars) {
        setCars(orderedCars);
    }

    public void setCars(List<TrainCar> orderedCars) {
        // copy first: the caller's list may be built from this assembly's own car list
        List<TrainCar> incoming = new ArrayList<>(orderedCars);

        this.cars.clear();
        this.cars.addAll(incoming);

        for (TrainCar car : this.cars) {
            car.setAssembly(this);
        }
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

    // Losing a car from the middle of a consist leaves two halves that are no longer connected
    // to each other, so the assembly has to come apart with it - otherwise the rigid step would
    // keep dragging the far half along through the gap where the car used to be.
    //
    // The half holding the original index 0 keeps this assembly; the other half becomes a new
    // one. A half left with a single car is not an assembly at all, just a lone car again.
    public void removeCar(TrainCar car) {
        int index = cars.indexOf(car);
        if (index < 0) return;

        // copy before clearing - subList is a view onto the list we are about to empty
        List<TrainCar> front = new ArrayList<>(cars.subList(0, index));
        List<TrainCar> back = new ArrayList<>(cars.subList(index + 1, cars.size()));

        // both halves keep coasting at whatever the whole train was doing
        double inheritedSpeed = this.assemblySpeed;

        car.setAssembly(null);
        this.cars.clear();

        if (front.size() >= 2) {
            setCars(front); // this assembly carries on as the front half
        } else {
            detach(front, inheritedSpeed);
        }

        if (back.size() >= 2) {
            TrainAssembly split = new TrainAssembly(back);
            split.assemblySpeed = inheritedSpeed;
        } else {
            detach(back, inheritedSpeed);
        }
    }

    // fewer than two cars cannot be an assembly, so whatever is left goes back to being solo.
    // it keeps the train's speed in its own field so it coasts away instead of stopping dead.
    private static void detach(List<TrainCar> remnant, double inheritedSpeed) {
        for (TrainCar car : remnant) {
            car.setAssembly(null);
            car.speed = inheritedSpeed;
        }
    }

    public void accelerate(double throttle) {
        double alignment = this.getLead().getEdgeAlignment();
        this.assemblySpeed += (throttle * alignment) * TrainCar.ACCELERATION;
        this.assemblySpeed = alignment == 1
                ? Math.max(0, Math.min(TrainCar.MAX_SPEED, this.assemblySpeed))
                : Math.max(-TrainCar.MAX_SPEED, Math.min(0, this.assemblySpeed));
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

    public void syncAssemblyMovement(TrainCar car, double step) {
        car.speed = step;
        car.setDistanceAlongEdge(car.getDistanceAlongEdge() + step);
    }

    public void tickAssembly() {
        for (TrainCar car : this.cars) {
            if (car.isLocomotive() && car.getFirstPassenger() instanceof  Player player) {
                car.processInput(player);
            }
        }

        moveAssembly();
    }

    // The assembly is rigid, so every car has to move by the EXACT same amount every tick -
    // spacing is only preserved because the steps are identical, and any tick where they differ
    // changes the coupling gap permanently. That means the step has to be agreed on BEFORE
    // anything moves: work out what each car can manage, take the most restrictive answer, then
    // apply that one step to the whole train. One blocked car stops the entire assembly.
    public void moveAssembly() {
        double step = this.assemblySpeed;

        // pass 1 - decide. the most restricted car wins; nothing has moved yet.
        for (TrainCar car : this.cars) {
            step = car.clampStepToEdge(step);
        }

        boolean blocked = (step != this.assemblySpeed);

        // pass 2 - apply the agreed step, identically, to everyone.
        for (TrainCar car : this.cars) {
            syncAssemblyMovement(car, step);
        }

        // being cut short means we ran into a buffer, so drop the throttle rather than letting
        // it re-accelerate into the same wall next tick and creep the train forward.
        if (blocked) {
            stopAssembly();
        }
    }
}


