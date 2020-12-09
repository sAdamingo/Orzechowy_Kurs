package com.sAdamingo.course;

import java.util.concurrent.TimeUnit;

public class Cracker implements Runnable {
    private int start;
    private int end;
    public static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789@#&!()^=+/:.;,".toCharArray();
    private static boolean FOUND = false;
    private String passwordToCrack;
    private String password;

    public Cracker(int start, int end, String passwordToCrack) {
        this.start = start;
        this.end = end;
        this.passwordToCrack = passwordToCrack;
    }

    public void generator(String s, int max_char) {

        if (s.length() == max_char) {
            // System.out.println(s);
            if (s.equals(passwordToCrack)) {
                password = s;
                FOUND = true;
                return;
            }
            return;
        }
        for (int i = 0; i < ALPHABET.length && !FOUND; i++) {
            String t = s;
            t += ALPHABET[i];
            generator(t, max_char);
        }

    }

    public void CrackInRange(int start, int stop) {
        while (!FOUND) {
            for (int i = start; i <= stop; i++) {
                generator("", i);
            }
        }
        return;
    }

    @Override
    public void run() {
        CrackInRange(start, end);

        if (FOUND) {
            long duration = System.currentTimeMillis() - PasswordCracker.START_TIME;
            System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(duration) + "." + TimeUnit.MILLISECONDS.toMillis(duration) + " sec. Password was = " + password);
        } else {
            System.out.println("Password not cracked for subset [" + start + ", " + end + "]");
        }
    }
}