package com.sAdamingo.course.Task23;

import java.io.IOException;

public class PlayCommand extends Command {
    PlayCommand(AudioPlayerGUI player, AudioPlayer musicPlayer) {
        super(player, musicPlayer);
    }

    @Override
    public boolean execute() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    musicPlayer.play();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.run();
        return false;
    }
}