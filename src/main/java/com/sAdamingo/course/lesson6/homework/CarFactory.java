package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class CarFactory {
    public Car create(int carPriceMin, int carPriceMax, int profitPercent) {
        int price;
        Random randomGen = new Random();
        if (carPriceMax < carPriceMin) {
            throw new IllegalArgumentException("carPriceMax have to be bigger than carPriceMin!");
        } else if (carPriceMax == carPriceMin) {
            price = carPriceMin;
        } else {
            price = carPriceMin +
                    randomGen.nextInt(carPriceMax - carPriceMin);
        }
        String type = Constants.VEHICLE_TYPES[randomGen.nextInt(
                Constants.VEHICLE_TYPES.length)];

        return new Car(price, price * profitPercent / 100, type);
    }
}
