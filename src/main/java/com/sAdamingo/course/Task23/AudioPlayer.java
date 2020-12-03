package com.sAdamingo.course.Task23;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer implements LineListener {

    private boolean playCompleted;
    private boolean isStopped;
    private boolean isPaused;
    private Clip audioClip;

    public void load(String audioFilePath)
            throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        File audioFile = new File(audioFilePath);
        AudioInputStream audioStream = AudioSystem
                .getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.addLineListener(this);
        audioClip.open(audioStream);
    }

    void play() {

        playCompleted = false;
        isStopped = false;
        audioClip.start();

    }

    public void stop() {
        isStopped = true;
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP) {
            System.out.println("STOP EVENT");
            if (isStopped || !isPaused) {
                playCompleted = true;
            }
        }
    }

    public Clip getAudioClip() {
        return audioClip;
    }
}