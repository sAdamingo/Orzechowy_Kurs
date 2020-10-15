package com.sAdamingo.course.lesson3.homework;

public class Task71 {
    public static void main(String[] args) {
        String inputString = getString();
        evenOrNot(inputString);
    }

    private static String getString() {
        return "Laborki z metrologii myk i pykk";
    }

    private static void evenOrNot(String inputString) {
        if (inputString.length() % 2 == 0) {
            System.out.println("has an even number of characters");
        } else {
            System.out.println("If you added 1 more character to " + inputString + " it would have an even number of characters");
        }
    }
}
