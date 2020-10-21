package com.sAdamingo.course.Lesson5.homework;

import java.util.Calendar;

public class Pesel {
    public static final int[] CONTROL_MULTIPLIERS = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
    public static final int PESEL_LENGTH = 11;
    public static final int AGE_LIMIT = 18;
    public static String pesel;

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    protected boolean checkPesel() {
        int controlSum = 0;
        boolean peselLengthOk = true;
        boolean isControlSumOk = true;

        if (pesel.length() != PESEL_LENGTH) {
            peselLengthOk = false;
        } else {
            for (int i = 0; i < PESEL_LENGTH - 1; i++) {
                int peselAt = Integer.parseInt(String.valueOf(pesel.charAt(i)));
                int currentNum = peselAt * CONTROL_MULTIPLIERS[i];
                currentNum %= 10;
                controlSum += currentNum;
            }
            controlSum = 10 - (controlSum % 10);
            isControlSumOk = controlSum == Integer.parseInt(String.valueOf(pesel.charAt(pesel.length() - 1)));
        }

        if (peselLengthOk && isControlSumOk) {
            return true;
        } else {
            return false;
        }
    }

    protected int checkAge() {
        int month = Integer.parseInt(pesel.substring(2, 4));
        int lastTwoOfBirthYear = Integer.parseInt(pesel.substring(0, 2));
        int age;
        if (month >= 81 && month <= 92) {
            age = Calendar.getInstance().get(Calendar.YEAR) - (1800 + lastTwoOfBirthYear);
        } else if (month >= 1 && month <= 12) {
            age = Calendar.getInstance().get(Calendar.YEAR) - (1900 + lastTwoOfBirthYear);
        } else if (month >= 21 && month <= 32) {
            age = Calendar.getInstance().get(Calendar.YEAR) - (2000 + lastTwoOfBirthYear);
        } else {
            age = Integer.MAX_VALUE;
        }
        return age;
    }
}




