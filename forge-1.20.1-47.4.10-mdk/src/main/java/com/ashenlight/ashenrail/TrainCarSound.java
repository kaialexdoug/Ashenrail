package com.ashenlight.ashenrail;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraftforge.registries.RegistryObject;

public class TrainCarSound extends AbstractTickableSoundInstance {
    private final TrainCar trainCar;

    public TrainCarSound(TrainCar trainCar, RegistryObject<SoundEvent> sound) {
        super(
                sound.get(),
                SoundSource.NEUTRAL,
                RandomSource.create()
        );

        this.trainCar = trainCar;

        this.looping = true;
    }

    public void startSound() {
        System.out.println("STARTING SOUND INSTANCE - TrainCar: " + this.trainCar.getId());
        Minecraft.getInstance().getSoundManager().play(this);
    }

    public void stopSound() {
        System.out.println("STOPPING SOUND INSTANCE - TrainCar: " + this.trainCar.getId());
        this.stop();
    }

    public void updateVolume() {
        float threshold = 0.2f;
        float movement = (float) this.trainCar.getAbsSpeed();

        if (movement >= threshold) {
            this.volume = 1.0f;
        } else {
            this.volume = movement / threshold;
        }
    }

    public void updatePitch() {
        float maxPitch = 1.5f;
        float movement = (float) this.trainCar.getAbsSpeed();

        this.pitch = 1.0f + (movement / (float) TrainCar.MAX_SPEED) * (maxPitch - 1.0f);
    }

    @Override
    public void tick() {
        if (this.trainCar.isRemoved()) {
            this.stopSound();
            return;
        }

        this.x = trainCar.getX();
        this.y = trainCar.getY();
        this.z = trainCar.getZ();
    }
}
