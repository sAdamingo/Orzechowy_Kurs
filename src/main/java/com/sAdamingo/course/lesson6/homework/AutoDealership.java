package com.sAdamingo.course.lesson6.homework;

import java.util.List;
import java.util.Random;

public class AutoDealership {
    private int capacity;
    private int carPriceMin;
    private int carPriceMax;
    private int maxClientsPerMonth;
    private int clientBudgetMin;
    private int clientBudgetMax;
    private int depreciation;
    private List<Car> cars;

    public AutoDealership(int capacity, int carPriceMin, int carPriceMax,
                          int maxClientsPerMonth, int clientBudgetMin,
                          int clientBudgetMax, int depreciation, List<Car> cars) {
        this.capacity = capacity;
        this.carPriceMin = carPriceMin;
        this.carPriceMax = carPriceMax;
        this.maxClientsPerMonth = maxClientsPerMonth;
        this.clientBudgetMin = clientBudgetMin;
        this.clientBudgetMax = clientBudgetMax;
        this.depreciation = depreciation;
        this.cars = cars;
    }

    void carSupply() {
        for (int i = 0; i < Constants.CAPACITY; i++) {
            if (cars.size() <= i) {
                cars.add(new Car(Constants.CAR_PRICE_MIN, Constants.CAR_PRICE_MAX));
            } else if (cars.get(i).isSold()) {
                cars.remove(i);
                cars.add(new Car(Constants.CAR_PRICE_MIN, Constants.CAR_PRICE_MAX));
            } else {
                cars.get(i).deprecatePrice();
            }
        }
    }

    int randomClientGenerator() {
        Random randGen = new Random();
        int profit = 0;
        int i = 0;
        int carsSold = 0;
        for (; i < randGen.nextInt(Constants.MAX_CLIENTS_PER_MONTH); i++) {
            Client customer = new Client(Constants.CLIENT_BUDGET_MIN, Constants.CLIENT_BUDGET_MAX);
            int carsPrizes;

            int bestDealPrice = customer.getBudget();
            int indexOfBestDeal = -1;

            for (int j = 0; j < cars.size(); j++) {
                carsPrizes = customer.getBudget() - cars.get(j).getPrice();
                if (carsPrizes >= 0 && carsPrizes < bestDealPrice && !cars.get(j).isSold()) {
                    indexOfBestDeal = j;
                    bestDealPrice = cars.get(j).getPrice();
                }
            }
            if (indexOfBestDeal != -1) {
                profit += bestDealPrice;
                cars.get(indexOfBestDeal).sell();
                carsSold++;
            }
        }
        System.out.println("You had " + i + " clients this month and sold " + carsSold + " cars.");
        return profit;
    }
    
}
