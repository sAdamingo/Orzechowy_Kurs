package com.sAdamingo.course.lesson6.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SalesSimulator {
    public static void main(String[] args) {
        LocalDate current = LocalDate.now();

        List<Car> cars = new ArrayList<>();
        AutoDealership stelmachowozy = new AutoDealership(Constants.CAPACITY,
                Constants.CAR_PRICE_MIN, Constants.CAR_PRICE_MAX,
                Constants.MAX_CLIENTS_PER_MONTH, Constants.CLIENT_BUDGET_MIN,
                Constants.CLIENT_BUDGET_MAX, Constants.DEPRECIATION, cars);
        autoDealershipSimulator(stelmachowozy, current);
    }

    private static void autoDealershipSimulator(AutoDealership stelmachowozy, LocalDate current) {

        int[] monthlyProfit = new int[Constants.SIMULATION_TIME_IN_MONTHS];
        int profit = 0;
        for (int i = 0; i < Constants.SIMULATION_TIME_IN_MONTHS; i++) {
            stelmachowozy.carSupply();
            monthlyProfit[i] = stelmachowozy.randomClientGenerator();
            System.out.println("In " + current.getMonth() + " you have sold cars for : "
                    + monthlyProfit[i] + " $ with net profit of " + Math.round(monthlyProfit[i] * Constants.PROFIT_PERCENTAGE) + " $.");
            current = current.plusMonths(1);
            profit += monthlyProfit[i];
        }
        System.out.println();
        System.out.println("Total profit for simulated period is: " + Math.round(profit * Constants.PROFIT_PERCENTAGE) + " $.");
    }


}
