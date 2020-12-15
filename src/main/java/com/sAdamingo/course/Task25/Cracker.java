package com.sAdamingo.course.Task25;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Cracker implements Runnable {
    private final int start;
    private final int end;
    public char[] alphabet;
    public AtomicBoolean isFound;
    private final String passwordToCrack;
    private String password;
    private long startTime;


    public Cracker(int start, int end, String passwordToCrack, AtomicBoolean aB, char[] alphabet, long startTime) {
        this.alphabet = alphabet;
        this.isFound = aB;
        this.start = start;
        this.end = end;
        this.passwordToCrack = passwordToCrack;
        this.startTime = startTime;
    }

    public void generator(String s, int max_char) {
        if (s.length() == max_char) {
            if (s.equals(passwordToCrack)) {
                password = s;
                isFound.set(true);
                return;
            }
            return;
        }
        for (int i = 0; i < alphabet.length && !isFound.get(); i++) {
            String t = s;
            t += alphabet[i];
            generator(t, max_char);
        }
    }

    public void crackInRange(int start, int stop) {
        boolean stopLoop = false;
        while (!isFound.get() || !stopLoop) {
            for (int i = start; i <= stop; i++) {
                generator("", i);
            }
            stopLoop = !stopLoop;
        }
    }

    @Override
    public void run() {
        crackInRange(start, end);
        if (isFound.get()) {
            long duration = System.currentTimeMillis() - startTime;
            if (password == null) {
                System.out.println("Password cracked by other thread!");
            } else {
                System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(duration) + "." + TimeUnit.MILLISECONDS.toMillis(duration) + " sec. Password was = " + password);
            }
        } else {
            System.out.println("Password not cracked for subset [" + start + ", " + end + "]");
        }
    }
}