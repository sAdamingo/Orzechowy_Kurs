package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class Car {
    private int price;

    private boolean sold;

    public Car(int carPriceMin, int carPriceMax) {
        setPrice(carPriceMin, carPriceMax);
        this.sold = false;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int carPriceMin, int carPriceMax) {
        Random randomGen = new Random();
        this.price = carPriceMin +
                randomGen.nextInt(carPriceMax - carPriceMin);
    }
    
    public void sell() {
        this.sold = true;
    }

    public boolean isSold() {
        return sold;
    }

    public void deprecatePrice() {
        this.price -= Constants.DEPRECIATION;
    }


}
