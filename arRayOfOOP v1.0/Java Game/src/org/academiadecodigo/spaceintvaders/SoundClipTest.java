package org.academiadecodigo.spaceintvaders;


import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class SoundClipTest extends JFrame {

        public SoundClipTest(String source) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Test Sound Clip");
            this.setSize(300, 200);
            this.setVisible(false);

            try {
                // Open an audio input stream.
                URL url = this.getClass().getClassLoader().getResource(source);
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                // Get a sound clip resource.
                Clip clip = AudioSystem.getClip();
                // Open audio clip and load samples from the audio input stream.
                clip.open(audioIn);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }


}
