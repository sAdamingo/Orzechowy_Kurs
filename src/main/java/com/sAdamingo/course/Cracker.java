package com.sAdamingo.course;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Cracker implements Runnable {
    private final int start;
    private final int end;
    public char[] ALPHABET;
    public AtomicBoolean FOUND;
    private final String passwordToCrack;
    private String password;


    public Cracker(int start, int end, String passwordToCrack, AtomicBoolean aB, char[] alphabet) {
        this.ALPHABET = alphabet;
        this.FOUND = aB;
        this.start = start;
        this.end = end;
        this.passwordToCrack = passwordToCrack;
    }

    public void generator(String s, int max_char) {

        if (s.length() == max_char) {
            // System.out.println(s);
            if (s.equals(passwordToCrack)) {
                password = s;
                FOUND.set(true);
                return;
            }
            return;
        }
        for (int i = 0; i < ALPHABET.length && !FOUND.get(); i++) {
            String t = s;
            t += ALPHABET[i];
            generator(t, max_char);
        }

    }

    public void CrackInRange(int start, int stop) {
        boolean stopLoop = false;
        while (!FOUND.get() || !stopLoop) {
            for (int i = start; i <= stop; i++) {
                generator("", i);
            }
            stopLoop = !stopLoop;
        }
    }

    @Override
    public void run() {
        CrackInRange(start, end);

        if (FOUND.get()) {
            long duration = System.currentTimeMillis() - PasswordCracker.START_TIME;
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