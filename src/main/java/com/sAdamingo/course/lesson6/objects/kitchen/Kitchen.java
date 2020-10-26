package com.sAdamingo.course.lesson6.objects.kitchen;

import java.util.Scanner;

public class Kitchen {

    public static void main(String[] args) {
        System.out.println("Name the first pot pls");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Pot pot1 = new Pot();
        Pot pot2 = pot1;

        pot1.setName(name);
        pot1.addWater(1000);

        System.out.println("Is " + pot1.getName() + " boiling? " + pot1.isBoiling());
        pot1.heatUp(30);
        System.out.println("Is " + pot1.getName() + " boiling? " + pot1.isBoiling());
        System.out.println(
                pot1.getHowMuchWaterInMl() + " ml of water is now at " + pot1.getTemperature()
                        + " degrees");
        pot1.heatUp(50);
        System.out.println("Is " + pot1.getName() + " boiling? " + pot1.isBoiling());

    }

}
