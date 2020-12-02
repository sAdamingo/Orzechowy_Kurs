package com.sAdamingo.course.Task23;

public class StopCommand extends Command {
    StopCommand(AudioPlayerGUI player, AudioPlayer musicPlayer) {
        super(player, musicPlayer);
    }

    @Override
    public boolean execute() {
        musicPlayer.stop();
        return false;
    }
}