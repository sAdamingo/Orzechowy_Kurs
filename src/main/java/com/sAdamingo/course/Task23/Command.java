package com.sAdamingo.course.Task23;

public abstract class Command {
    public AudioPlayerGUI player;
    private String backup;
    AudioPlayer musicPlayer;

    Command(AudioPlayerGUI player, AudioPlayer musicPlayer) {
        this.player = player;
        this.musicPlayer = musicPlayer;
    }

    public abstract boolean execute();
}