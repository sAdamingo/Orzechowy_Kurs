package com.sAdamingo.course.Lesson5.homework;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class PawnStars {
    public static void main(String[] args) {
        Scanner skn = new Scanner(System.in);
        System.out.println("Welcome to PAWN Stars! Please let us confirm your PESEL number!");
        System.out.println("Enter PESEL:");
        Pesel pesel = new Pesel(skn.nextLine());
        if (pesel.checkAge(pesel.checkPesel())) {
            pesel.checkItem(skn.nextLine());
        }
    }

    public static class Pesel {
        public static final int[] CONTROL_MULTIPLIERS = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        public static final int PESEL_LENGTH = 11;
        public static final List<String> FORBIDDEN_ITEMS = List.of("gun", "human", "AK-47", "Cocaine", "chocolate");
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
                System.out.println("You tried to trick me you cheeky bastard!");
                return false;
            }
        }

        protected boolean checkAge(boolean isCheckPeselOK) {
            if (isCheckPeselOK) {
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
                    return false;
                }

                if (age >= AGE_LIMIT && age < 110) {
                    System.out.println("So, you are " + age + " years old. What are you selling?");
                    return true;
                } else if (age < 0) {
                    System.out.println("You came from future or what? Get out od here!");
                    return false;
                } else if (age > 110) {
                    System.out.println("You're so old that I better call the newspaper!");
                    return false;
                } else {
                    System.out.println("Come back in " + (AGE_LIMIT - age) + " years!");
                    return false;
                }
            } else {
                return false;
            }
        }

        protected void checkItem(String scannerInput) {
            if (FORBIDDEN_ITEMS.contains(scannerInput)) {
                System.out.println("Sorry, we don't deal with this stuff");
            } else {
                System.out.println("We can give you $" + scannerInput.length() * 0.45 + " for it, take it or leave it");
            }
        }
    }
}