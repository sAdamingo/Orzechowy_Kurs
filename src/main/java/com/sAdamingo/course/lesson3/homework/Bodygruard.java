package com.sAdamingo.course.lesson3.homework;

public class Bodygruard {
    public static void main(String[] args) {
        int iq = getIq();
        String password = getPassword();
        canEnterClub(check(iq, password));
    }

    private static String getPassword() {
        return "ParostatkiemWPięknyRejs";
    }

    private static int getIq() {
        return 131;
    }

    private static boolean check(int iq, String password) {
        return iq > 130 && PasswordChecker.checkPassword(password);
    }

    private static void canEnterClub(boolean canEnter) {
        System.out.println(canEnter ? "Welcome!" : "Get the fuck out of here!");
    }
}

