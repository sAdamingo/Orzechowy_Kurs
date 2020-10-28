package com.sAdamingo.course.lesson6.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SalesSimulator {
    public static void main(String[] args) {
        LocalDate current = LocalDate.now();
        List<Car> cars = new ArrayList<>();
        List<Client> customers = new ArrayList<>();
        AutoDealership stelmachowozy = new AutoDealership(20,
                15000, 25000,
                20, 13000,
                22000, 500, cars, customers);
        autoDealershipSimulator(stelmachowozy, current, 10);

        cars.clear();
        customers.clear();
        AutoDealership dealerAutoFiat = new AutoDealership(60,
                15000, 20000,
                80, 130000,
                190000, 2500, cars, customers);
        autoDealershipSimulator(dealerAutoFiat, current, 24);

        cars.clear();
        customers.clear();
        AutoDealership zlomnikSzrot = new AutoDealership(6000,
                1500, 6000,
                7000, 3000,
                8000, 100, cars, customers);
        autoDealershipSimulator(zlomnikSzrot, current, 24);
    }

    private static void autoDealershipSimulator(AutoDealership stelmachowozy, LocalDate current, int simulationTimeInMonths) {
        int[] monthlyProfit = new int[simulationTimeInMonths];
        int profit = 0;
        for (int i = 0; i < simulationTimeInMonths; i++) {
            stelmachowozy.carSupply();
            monthlyProfit[i] = stelmachowozy.randomClientGenerator();
            System.out.println("In " + current.getMonth() + " you have sold cars for : "
                    + monthlyProfit[i] + " $ with net profit of " + Math.round(monthlyProfit[i] * 0.23) + " $.");
            current = current.plusMonths(1);
            profit += monthlyProfit[i];
        }
        System.out.println();
        System.out.println("Total profit for simulated period is: " + Math.round(profit * 0.23) + " $.");
        System.out.println();
    }
}