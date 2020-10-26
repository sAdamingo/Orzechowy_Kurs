package com.sAdamingo.course.lesson6.objects;

import com.sAdamingo.course.lesson6.objects.cars.Porsche;
import com.sAdamingo.course.lesson6.objects.cars.Tractor;

public class RaceTrack {

    public static void main(String[] args) {
        Porsche porsche = new Porsche();
        porsche.addTurbo();

        Porsche gorszePorsche = new Porsche();

        System.out.println(
                "max speed p1 " + porsche.getMaxSpeed() + " max speed p2 " + gorszePorsche.getMaxSpeed());

        Tractor tractor = new Tractor();

        System.out.println(
                "can my tractor go as fast as p2? " + tractor.canGoThisFast(gorszePorsche.getMaxSpeed()));
    }
}
