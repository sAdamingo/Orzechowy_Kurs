package com.sAdamingo.course.lesson6.homework;

public class Client {

    private int budget;
    private String preferredCarType;
    private boolean carBought = false;
    private int monthsWaiting = 0;


    public Client(int budget, String preferredCarType, boolean carBought, int monthsWaiting) {
        this.budget = budget;
        this.preferredCarType = preferredCarType;
        this.carBought = carBought;
        this.monthsWaiting = monthsWaiting;
    }
    
    public String getPreferredCarType() {
        return preferredCarType;
    }

    public int getBudget() {
        return budget;
    }

    public int getMonthsWaiting() {
        return monthsWaiting;
    }

    public void buyCar() {
        this.carBought = true;
    }

    public boolean isCarBought() {
        return carBought;
    }

    void addMonthOfWaiting() {
        this.monthsWaiting++;
    }
}