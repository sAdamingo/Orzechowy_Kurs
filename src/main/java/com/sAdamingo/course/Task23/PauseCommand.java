package com.sAdamingo.course.Task23;

public class PauseCommand extends Command {
    PauseCommand(AudioPlayerGUI player, AudioPlayer musicPlayer) {
        super(player, musicPlayer);
    }

    @Override
    public boolean execute() {
        musicPlayer.pause();
        return false;
    }
}