package com.sAdamingo.course.lesson6.homework;

import java.util.List;
import java.util.Random;

public class AutoDealership {
    private final int capacity;
    private final int carPriceMin;
    private final int carPriceMax;
    private final int maxClientsPerMonth;
    private final int clientBudgetMin;
    private final int clientBudgetMax;
    private final int depreciation;
    private List<Car> cars;
    private List<Client> customers;

    public AutoDealership(int capacity, int carPriceMin, int carPriceMax,
                          int maxClientsPerMonth, int clientBudgetMin,
                          int clientBudgetMax, int depreciation, List<Car> cars, List<Client> customers) {
        this.capacity = capacity;
        this.carPriceMin = carPriceMin;
        this.carPriceMax = carPriceMax;
        this.maxClientsPerMonth = maxClientsPerMonth;
        this.clientBudgetMin = clientBudgetMin;
        this.clientBudgetMax = clientBudgetMax;
        this.depreciation = depreciation;
        this.cars = cars;
        this.customers = customers;
    }

    void carSupply() {
        for (int i = 0; i < capacity; i++) {
            if (cars.size() <= i) {
                cars.add(new Car(carPriceMin, carPriceMax));
            } else if (cars.get(i).isSold()) {
                cars.remove(i);
                cars.add(0, new Car(carPriceMin, carPriceMax));
            } else {
                cars.get(i).deprecatePrice(depreciation);
            }
        }
    }


    void clientListUpdate() {
        for (int k = customers.size() - 1; k >= 0; k--) {
            if (customers.get(k).isCarBought()
                    || customers.get(k).getMonthsWaiting() >= 4) {
                customers.remove(k);
            }
        }
    }

    public int getMonthlyProfit() {
        Random randGen = new Random();
        int i = 0;
        int profit = 0;
        int carsSold = 0;
        int customersSizeAtInit = 0;
        int iterations = customersSizeAtInit + randGen.nextInt(maxClientsPerMonth);

        for (; i < iterations; i++) {
            if (i >= customersSizeAtInit) {
                customers.add(new Client(clientBudgetMin,
                        clientBudgetMax));
            }
            int bestDealPrice = 0;
            int indexOfBestDeal = -1;

            for (int j = 0; j < cars.size(); j++) {
                if (customers.get(i).getBudget() >= cars.get(j).getPrice() && cars.get(j).getPrice() > bestDealPrice
                        && !cars.get(j).isSold()
                        && customers.get(i).getPreferredCarType().equals(cars.get(j).getType())) {
                    indexOfBestDeal = j;
                    bestDealPrice = cars.get(j).getPrice();
                }
            }
            if (indexOfBestDeal != -1) {
                profit += cars.get(indexOfBestDeal).getProfit();
                cars.get(indexOfBestDeal).sell();
                carsSold++;
                customers.get(i).buyCar();
            } else {
                customers.get(i).addMonthOfWaiting();
            }
        }
        System.out.println("You had " + i + " clients this month and sold "
                + carsSold + " cars.");
        return profit;
    }
}