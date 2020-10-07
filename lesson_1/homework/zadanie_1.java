package com.sAdamingo.course.lesson_1.homework;

public class zadanie_1 {
    public static void main(String[] args) {
        String inputString = "Laborki z metrologii myk i pykk";
        if (inputString.length() % 2 == 0) {
            System.out.println("has an even number of characters");
        } else {
            System.out.println("If you added 1 more character to " + inputString + " it would have an even number of characters");
        }
    }
}
