package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class Car {
    private int price;
    private int profit;
    private String type;
    private boolean sold;

    public int getProfit() {
        return profit;
    }

    public void setProfit() {
        this.profit = (int) Math.round(price * 0.1);
    }

    public String getType() {
        return type;
    }

    public Car(int carPriceMin, int carPriceMax) {
        setPrice(carPriceMin, carPriceMax);
        setType();
        setProfit();
        this.sold = false;
    }

    public int getPrice() {
        return price;
    }

    private void setType() {
        Random randomGen = new Random();
        this.type = Constants.VEHICLE_TYPES[randomGen.nextInt(Constants.VEHICLE_TYPES.length)];
    }

    private void setPrice(int carPriceMin, int carPriceMax) {
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

    public void deprecatePrice(int depreciation) {
        this.price -= depreciation;
        this.profit -= depreciation;
    }
}