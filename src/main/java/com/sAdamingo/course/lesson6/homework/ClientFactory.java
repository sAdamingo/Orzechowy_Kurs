package com.sAdamingo.course.lesson6.homework;

import java.util.Random;

public class ClientFactory {
    public Client create(int clientBudgetMin, int clientBudgetMax) {
        int budget;
        if (clientBudgetMax < clientBudgetMin) {
            throw new IllegalArgumentException("carPriceMax have to be bigger than carPriceMin!");
        } else if (clientBudgetMax == clientBudgetMin) {
            budget = clientBudgetMin;
        } else {
            Random randomGen = new Random();
            budget = clientBudgetMin +
                    randomGen.nextInt(clientBudgetMax - clientBudgetMin);
        }
        Random randGen = new Random();
        String preferredCarType = Constants.VEHICLE_TYPES[randGen.nextInt(Constants.VEHICLE_TYPES.length)];
        return new Client(budget, preferredCarType, false, 0);
    }
}
