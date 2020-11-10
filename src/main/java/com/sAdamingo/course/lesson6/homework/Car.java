package com.sAdamingo.course.lesson6.homework;

public class Car {
    private int price;
    private int profit;
    private final String type;
    private boolean sold;

    public Car(int price, int profit, String type) {
        this.price = price;
        this.profit = profit;
        this.type = type;
        this.sold = false;
    }

    public int getProfit() {
        return profit;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void sell() {
        this.sold = true;
    }

    public boolean isSold() {
        return sold;
    }

    public void deprecatePrice(int depreciation) {
        this.profit -= price * depreciation / 100;
        this.price -= price * depreciation / 100;
    }
}