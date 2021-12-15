package org.academiadecodigo.spaceintvaders;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundFactory {

    public File gameStartSound, kidnapSound, arrowSound;

    public SoundFactory(){

        gameStartSound = new File("audio/world/door.wav");
        kidnapSound = new File("audio/NPC/shade/shade12.wav");
        arrowSound = new File("audio/battle/swing.wav");

    }

    public File getKidnapSound() {
        return kidnapSound;
    }

    public File getArrowSound() {
        return arrowSound;
    }

    public void playSound(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 10);

            } catch (Exception e) {

        }

    }



}