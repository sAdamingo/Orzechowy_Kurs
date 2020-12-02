package com.sAdamingo.course.Task23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioPlayerGUI extends Component {
    public JTextArea textField;
    public String filePath;
    private CommandHistory history = new CommandHistory();

    public void init() {
        JFrame frame = new JFrame("My first AudioPlayer");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        JProgressBar timer = new JProgressBar();
        content.add(timer);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton openFile = new JButton("Open File");
        JButton play = new JButton("Play");
        JButton pause = new JButton("Pause");
        JButton stop = new JButton("Stop");
        AudioPlayerGUI audioPlayer = this;
        AudioPlayer musicPlayer = new AudioPlayer();

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new OpenFileCommand(audioPlayer, musicPlayer));
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PlayCommand(audioPlayer, musicPlayer));
            }
        });

        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PauseCommand(audioPlayer, musicPlayer));
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new StopCommand(audioPlayer, musicPlayer));
            }
        });

        buttons.add(openFile);
        buttons.add(play);
        buttons.add(pause);
        buttons.add(stop);
        content.add(buttons);
        frame.setSize(450, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }
}