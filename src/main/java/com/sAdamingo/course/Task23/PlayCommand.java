package com.sAdamingo.course.Task23;

public class PlayCommand extends Command {
    PlayCommand(AudioPlayerGUI player, AudioPlayer musicPlayer) {
        super(player, musicPlayer);
    }

    @Override
    public boolean execute() {
        musicPlayer.play();
        return false;
    }
}