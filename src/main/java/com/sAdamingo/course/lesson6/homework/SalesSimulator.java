package com.sAdamingo.course.lesson6.homework;

import java.time.LocalDate;


public class SalesSimulator {
    public static void main(String[] args) {
        LocalDate current = LocalDate.now();

        AutoDealership stelmachowozy = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMax(30)
                .withCarPriceMin(20)
                .withCapacity(20)
                .withClientBudgetMin(15)
                .withClientBudgetMax(25)
                .withDepreciation(10)
                .withMaxClientsPerMonth(15)
                .withCarFactory(new CarFactory())
                .withClientFactory(new ClientFactory())
                .build();
        autoDealershipSimulator(stelmachowozy, current, 10);

        AutoDealership dealerAutoFiat = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMax(20000)
                .withCarPriceMin(15000)
                .withCapacity(60)
                .withClientBudgetMin(130000)
                .withClientBudgetMax(190000)
                .withDepreciation(50)
                .withMaxClientsPerMonth(80)
                .withCarFactory(new CarFactory())
                .withClientFactory(new ClientFactory())
                .build();

        autoDealershipSimulator(dealerAutoFiat, current, 24);

        AutoDealership zlomnikSzrot = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMax(6000)
                .withCarPriceMin(1000)
                .withCapacity(2)
                .withClientBudgetMin(30000)
                .withClientBudgetMax(80000)
                .withDepreciation(10)
                .withMaxClientsPerMonth(120)
                .withCarFactory(new CarFactory())
                .withClientFactory(new ClientFactory())
                .build();

        autoDealershipSimulator(zlomnikSzrot, current, 24);
    }

    private static void autoDealershipSimulator(AutoDealership stelmachowozy, LocalDate current, int simulationTimeInMonths) {
        int[] monthlyProfit = new int[simulationTimeInMonths];
        int profit = 0;
        for (int i = 0; i < simulationTimeInMonths; i++) {
            stelmachowozy.carSupply();
            System.out.println();
            monthlyProfit[i] = stelmachowozy.getMonthlyProfit();
            stelmachowozy.clientListUpdate();
            System.out.println("In " + current.getMonth() + " you have sold cars with net profit of " + monthlyProfit[i] + " $.");
            current = current.plusMonths(1);
            profit += monthlyProfit[i];
        }
        System.out.println();
        System.out.println("Total profit for simulated period is: " + Math.round(profit * 0.23) + " $.");
        System.out.println();
    }
}