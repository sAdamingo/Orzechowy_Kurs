package com.sAdamingo.course.Lesson5.homework;

import java.util.Scanner;

public class PawnStars {

    static final int AGE_LIMIT = 18;

    public static void main(String[] args) {
        welcomeToPawnStars();
        Scanner skn = new Scanner(System.in);
        Pesel pesel = new Pesel(skn.nextLine());
        if (!pesel.checkPesel()) {
            reply("You tried to trick me you cheeky bastard!");
        } else {
            int age = pesel.checkAge();
            String answer = getAnswer(age);
            reply(answer);
            if (answer.equals("So, you are " + age + " years old. What are you selling?")) {
                reply(sellItem(skn));
            }
        }
    }

    private static void reply(String answer) {
        System.out.println(answer);
    }

    private static String getAnswer(int age) {
        if (age >= AGE_LIMIT && age < 110) {
            return "So, you are " + age + " years old. What are you selling?";
        } else if (age < 0) {
            return "You came from future or what? Get out od here!";
        } else if (age > 110) {
            return "You're so old that I better call the newspaper!";
        } else {
            return "Come back in " + (AGE_LIMIT - age) + " years!";
        }
    }

    private static String sellItem(Scanner skn) {
        String Item = skn.nextLine();
        if (BlackList.FORBIDDEN_ITEMS.contains(Item)) {
            return "Sorry, we don't deal with this stuff";
        } else {
            return "We can give you $" + Item.length() * 0.45
                    + " for it, take it or leave it";
        }
    }

    private static void welcomeToPawnStars() {
        System.out.println("Welcome to PAWN Stars! Please let us confirm your PESEL number!");
        System.out.println("Enter PESEL:");
    }
}