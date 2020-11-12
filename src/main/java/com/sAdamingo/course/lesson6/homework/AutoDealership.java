package com.sAdamingo.course.lesson6.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoDealership {
    private final CarFactory carFactory;
    private final ClientFactory clientFactory;
    private final int capacity;
    private final int carPriceMin;
    private final int carPriceMax;
    private final int maxClientsPerMonth;
    private final int clientBudgetMin;
    private final int clientBudgetMax;
    private final int depreciation;
    private List<Car> cars;
    private List<Client> customers;


    public AutoDealership(CarFactory carFactory, ClientFactory clientFactory, int capacity, int carPriceMin, int carPriceMax,
                          int maxClientsPerMonth, int clientBudgetMin,
                          int clientBudgetMax, int depreciation) {
        this.carFactory = carFactory;
        this.clientFactory = clientFactory;
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Car dealership capacity is always an positive," +
                            " non-zero number!");
        } else {
            this.capacity = capacity;
        }

        this.carPriceMin = carPriceMin;
        this.carPriceMax = carPriceMax;

        if (maxClientsPerMonth <= 0) {
            throw new IllegalArgumentException(
                    "Car dealership maxClientsPerMonth value is always an positive," +
                            " non-zero number!");
        } else {
            this.maxClientsPerMonth = maxClientsPerMonth;
        }

        this.clientBudgetMin = clientBudgetMin;
        this.clientBudgetMax = clientBudgetMax;
        this.depreciation = depreciation;
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<Client> getCustomers() {
        return customers;
    }

    public List<Car> getCars() {
        return cars;
    }

    void carSupply() {
        for (int i = 0; i < capacity; i++) {
            if (cars.size() <= i) {
                cars.add(carFactory.create(carPriceMin, carPriceMax, 10));
            } else if (cars.get(i).isSold()) {
                cars.remove(i);
                cars.add(i, carFactory.create(carPriceMin, carPriceMax, 10));
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
                customers.add(clientFactory.create(clientBudgetMin,
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