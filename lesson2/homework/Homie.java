package com.sAdamingo.course.lesson2.homework;

public class Homie {
    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {
            if (i % 3 != 0) {
                String output = Integer.toString(i) + " ";
                if (i % 4 == 0) {
                    output = output + "Zio";
                }
                if (i % 5 == 0) {
                    output = output + "mek";
                }
                System.out.println(output);
            }
        }
    }
}

