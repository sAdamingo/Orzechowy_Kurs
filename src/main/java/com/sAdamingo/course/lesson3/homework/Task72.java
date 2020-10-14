package com.sAdamingo.course.lesson3.homework;

public class Task72 {
    public static void main(String[] args) {
        addOrSubstract(isAdding(), getA(), getB());
    }

    private static int getB() {
        return 555;
    }

    private static int getA() {
        return 666;
    }

    private static boolean isAdding() {
        return false;
    }

    private static void addOrSubstract(boolean isAdding, int a, int b) {
        if (isAdding) {
            int result = a + b;
            System.out.println(a + " plus " + b + " equals " + result);
        } else {
            int result = a - b;
            System.out.println(a + " minus " + b + " equals " + result);
        }
    }
}
