package com.sAdamingo.course.lesson3.homework;

public class Task76 {
    public static void main(String[] args) {
        int whichFibonacciNumber = getWhichFibonacciNumber();
        int fibonacciNumber = getFibonacciNumber(whichFibonacciNumber);
        printFibonacciNumber(fibonacciNumber);
    }

    private static void printFibonacciNumber(int fibonacciNumber) {
        System.out.println(fibonacciNumber);
    }

    private static int getFibonacciNumber(int whichFibonacciNumber) {
        int fibonacciNumber = 0;
        int fibonacciNumberPrevious = 0;
        int fibonacciNumberBeforePrevious;

        for (int i = 0; i <= whichFibonacciNumber; i++) {
            if (i == 0) {
                fibonacciNumber = 0;
            } else if (i == 1) {
                fibonacciNumberPrevious = 0;
                fibonacciNumber = 1;
            } else {
                fibonacciNumberBeforePrevious = fibonacciNumberPrevious;
                fibonacciNumberPrevious = fibonacciNumber;
                fibonacciNumber = fibonacciNumberPrevious + fibonacciNumberBeforePrevious;
            }
        }
        return fibonacciNumber;
    }

    private static int getWhichFibonacciNumber() {
        int whichFibonacciNumber = 25;
        return whichFibonacciNumber;
    }
}
