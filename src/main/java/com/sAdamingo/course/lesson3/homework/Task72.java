package com.sAdamingo.course.lesson3.homework;

public class Task72 {
    public static void main(String[] args) {
        int a = getA();
        int b = getB();
        calculate(a, b);
    }

    private static void calculate(int a, int b) {
        if (isAdding()) {
            add(a, b);
        } else {
            substracct(a, b);
        }
    }

    private static void substracct(int a, int b) {
        int result = a - b;
        System.out.println(a + " minus " + b + " equals " + result);
    }

    private static void add(int a, int b) {
        int result = a + b;
        System.out.println(a + " plus " + b + " equals " + result);
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

}
