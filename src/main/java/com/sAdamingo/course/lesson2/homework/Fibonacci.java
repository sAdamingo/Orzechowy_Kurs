package com.sAdamingo.course.lesson2.homework;

public class Fibonacci {
    public static void main(String[] args) {
        int whichFibonacciNumber = 25;
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
        System.out.println(fibonacciNumber);
    }
}
