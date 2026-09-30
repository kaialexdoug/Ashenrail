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
        Minecraft.getInstance().getSoundManager().play(this);
    }

    public void stopSound() {
        this.stop();
    }

    @Override
    public void tick() {
        this.x = trainCar.getX();
        this.y = trainCar.getY();
        this.z = trainCar.getZ();
    }
}
