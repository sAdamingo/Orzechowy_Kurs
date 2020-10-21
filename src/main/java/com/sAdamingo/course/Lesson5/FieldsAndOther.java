package com.sAdamingo.course.Lesson5;

import java.util.Scanner;
public class FieldsAndOther {
    private static final int ADULT_AGE = 18;
    private static String name;
    public static void main(String[] args) {
        if (args.length > 0) {
            String firstArg = args[0];
            System.out.println("First argument is " + firstArg);
        } else {
            System.out.println("Sorry, you didn't provide enough arguments");
            return;
        }
        System.out.println("Please tell me your name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!!");
        System.out.println("How old are you?");
        int age = Integer.parseInt(scanner.nextLine());
        sellSomething(age);
    }
    private static void sellSomething(int age) {
        if (age >= ADULT_AGE) {
            System.out.println("What do you need?");
        } else {
            System.out.println(
                    "Sorry, you're still just a kid, I'm calling the cops and telling them that " + name
                            + " tried to buy my products!");
        }
    }
}