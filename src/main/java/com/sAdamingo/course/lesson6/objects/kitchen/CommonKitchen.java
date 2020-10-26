package com.sAdamingo.course.lesson6.objects.kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonKitchen {

    public static void main(String[] args) {
        List<Spoon> spoons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            spoons.add(new Spoon());
        }

        for (int i = 0; i < 4; i++) {
            int randomInt = new Random().nextInt(spoons.size());
            Spoon spoon = spoons.get(randomInt);
            spoon.eat();
        }

        for (int i = 0; i < spoons.size(); i++) {
            if (spoons.get(i).isUsed()) {
                System.out.println("bleh, spoon number " + i + " has been used already!!!");
            } else {
                System.out.println("Okay, looks like spoon number " + i + " is clean.");
            }
        }
    }
}
