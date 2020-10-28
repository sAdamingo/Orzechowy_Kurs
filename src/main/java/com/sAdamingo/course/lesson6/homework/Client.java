package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class Client {
    private int budget;

    public void buyCar() {
        this.carBought = true;
    }

    private String preferredCarType;

    public boolean isCarBought() {
        return carBought;
    }

    private boolean carBought = false;


    public int getMonthsWaiting() {
        return monthsWaiting;
    }

    private int monthsWaiting = 0;

    public Client(int clientBudgetMin, int clientBudgetMax) {
        Random randomGen = new Random();
        this.budget = clientBudgetMin +
                randomGen.nextInt(clientBudgetMax - clientBudgetMin);
        setPreferredCarType();
    }

    void addMonthOfWaiting() {
        this.monthsWaiting++;
    }

    public String getPreferredCarType() {
        return preferredCarType;
    }

    public int getBudget() {
        return budget;
    }

    private void setPreferredCarType() {
        Random randGen = new Random();
        this.preferredCarType = Constants.VEHICLE_TYPES[randGen.nextInt(Constants.VEHICLE_TYPES.length)];
    }
}