package com.sAdamingo.course.lesson3.homework;

public class Task74 {
    public static void main(String[] args) {
        homiePrinter();
    }

    private static void homiePrinter() {
        for (int i = 1; i <= 150; i++) {
            if (i % 3 != 0) {
                System.out.print(i + " ");
                if (i % 4 == 0) {
                    System.out.print("Zio");
                }
                if (i % 5 == 0) {
                    System.out.print("mek");
                }
                System.out.println();
            }
        }
    }
}
