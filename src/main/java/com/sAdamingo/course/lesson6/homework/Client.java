package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class Client {
    private int budget;
    
    public Client(int clientBudgetMin, int clientBudgetMax) {
        Random randomGen = new Random();
        this.budget = clientBudgetMin +
                randomGen.nextInt(clientBudgetMax - clientBudgetMin);
    }

    public int getBudget() {
        return budget;
    }
}
