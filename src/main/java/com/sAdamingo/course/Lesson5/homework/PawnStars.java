package com.sAdamingo.course.Lesson5.homework;

import java.util.Scanner;

public class PawnStars {

    static final int AGE_LIMIT = 18;

    public static void main(String[] args) {
        welcomeToPawnStars();
        Scanner skn = new Scanner(System.in);
        Pesel pesel = new Pesel(skn.nextLine());
        if (!pesel.checkPesel()) {
            System.out.println("You tried to trick me you cheeky bastard!");
        } else {
            int age = pesel.checkAge();
            if (age >= AGE_LIMIT && age < 110) {
                System.out.println("So, you are " + age + " years old. What are you selling?");
                String Item = skn.nextLine();
                if (BlackList.FORBIDDEN_ITEMS.contains(Item)) {
                    System.out.println("Sorry, we don't deal with this stuff");
                } else {
                    System.out.println("We can give you $" + Item.length() * 0.45 + " for it, take it or leave it");
                }
            } else if (age < 0) {
                System.out.println("You came from future or what? Get out od here!");
            } else if (age > 110) {
                System.out.println("You're so old that I better call the newspaper!");
            } else {
                System.out.println("Come back in " + (AGE_LIMIT - age) + " years!");
            }
        }
    }

    private static void welcomeToPawnStars() {
        System.out.println("Welcome to PAWN Stars! Please let us confirm your PESEL number!");
        System.out.println("Enter PESEL:");
    }
}