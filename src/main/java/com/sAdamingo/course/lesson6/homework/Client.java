package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class Client {
    private final int budget;
    private String preferredCarType;
    private boolean carBought = false;
    private int monthsWaiting = 0;

    public Client(int clientBudgetMin, int clientBudgetMax) {
        Random randomGen = new Random();
        this.budget = clientBudgetMin +
                randomGen.nextInt(clientBudgetMax - clientBudgetMin);
        setPreferredCarType();
    }

    private void setPreferredCarType() {
        Random randGen = new Random();
        this.preferredCarType = Constants.VEHICLE_TYPES[randGen.nextInt(Constants.VEHICLE_TYPES.length)];
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