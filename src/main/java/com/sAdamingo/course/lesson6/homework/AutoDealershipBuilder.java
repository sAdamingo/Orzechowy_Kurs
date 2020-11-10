package com.sAdamingo.course.lesson6.homework;

public final class AutoDealershipBuilder {
    private CarFactory carFactory;
    private ClientFactory clientFactory;
    private int capacity;
    private int carPriceMin;
    private int carPriceMax;
    private int maxClientsPerMonth;
    private int clientBudgetMin;
    private int clientBudgetMax;
    private int depreciation;


    public static AutoDealershipBuilder anAutoDealership() {
        return new AutoDealershipBuilder();
    }

    public AutoDealershipBuilder withCarFactory(CarFactory carFactory) {
        this.carFactory = carFactory;
        return this;
    }

    public AutoDealershipBuilder withClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        return this;
    }


    public AutoDealershipBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public AutoDealershipBuilder withCarPriceMin(int carPriceMin) {
        this.carPriceMin = carPriceMin;
        return this;
    }

    public AutoDealershipBuilder withCarPriceMax(int carPriceMax) {
        this.carPriceMax = carPriceMax;
        return this;
    }

    public AutoDealershipBuilder withMaxClientsPerMonth(int maxClientsPerMonth) {
        this.maxClientsPerMonth = maxClientsPerMonth;
        return this;
    }

    public AutoDealershipBuilder withClientBudgetMin(int clientBudgetMin) {
        this.clientBudgetMin = clientBudgetMin;
        return this;
    }

    public AutoDealershipBuilder withClientBudgetMax(int clientBudgetMax) {
        this.clientBudgetMax = clientBudgetMax;
        return this;
    }

    public AutoDealershipBuilder withDepreciation(int depreciation) {
        this.depreciation = depreciation;
        return this;
    }

    public AutoDealership build() {
        return new AutoDealership(carFactory, clientFactory, capacity, carPriceMin, carPriceMax, maxClientsPerMonth, clientBudgetMin, clientBudgetMax, depreciation);
    }
}
