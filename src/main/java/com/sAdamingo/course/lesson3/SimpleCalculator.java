package com.sAdamingo.course.lesson3;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println(add(getFirstNumber(), getSecondnumber()));
        System.out.println(substract(getFirstNumber(), getSecondnumber()));
        System.out.println(multiply(getFirstNumber(), getSecondnumber()));
        System.out.println(divide(getFirstNumber(), getSecondnumber()));

        ResultPrinter.printResult(add(getFirstNumber(), getSecondnumber()));
    
    }

    public static double getFirstNumber() {
        return 1.5d;
    }

    public static double getSecondnumber() {
        return 4.3d;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double substract(double a, double b) {
        return a - b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }
}
