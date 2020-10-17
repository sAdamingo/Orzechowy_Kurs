package com.sAdamingo.course.lesson4.homework;

public class Task10 {
    public static void main(String[] args) {
        int[] myArray = getArray(1, 30);
        printArray(myArray);
    }

    private static void printArray(int[] myArray) {
        for (int value : myArray) {
            System.out.print(value + (value == myArray[myArray.length - 1] ? "" : ", "));
        }
    }

    private static int[] getArray(int initialNumber, int size) {
        int[] nextIsDouble = new int[size];
        nextIsDouble[0] = initialNumber;
        for (int i = 1; i < nextIsDouble.length; i++) {
            nextIsDouble[i] = nextIsDouble[i - 1] * 2;
        }
        return nextIsDouble;
    }
}
