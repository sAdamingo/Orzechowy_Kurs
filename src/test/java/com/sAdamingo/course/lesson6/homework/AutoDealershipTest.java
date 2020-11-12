package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class AutoDealershipTest {

    @Test
    @DisplayName("For empty cars list should return list with Car objects, size capacity")
    void shouldReturnCapacitySizedListOfCars() {
        List<Car> cars = new ArrayList<>();
        int capacity = 20;
        AutoDealership toyotaSalon = new AutoDealership(new CarFactory(), new ClientFactory(), capacity, 20, 30, 20, 15, 25, 5);

        toyotaSalon.carSupply();
        Assertions.assertEquals(cars.size(), capacity);
    }


    @Test
    @DisplayName("cars size should be equal to capacity")
    void cokolwiek() {
        CarFactory carFactory = Mockito.mock(CarFactory.class);
        ClientFactory clientFactory = Mockito.mock(ClientFactory.class);
        Mockito.when(carFactory
                .create(20, 30, 10))
                .thenReturn(new Car(25, 10, "Van"));
        int capacity = 20;
        AutoDealership salon = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMax(30)
                .withCarPriceMin(20)
                .withCapacity(capacity)
                .withClientBudgetMin(15)
                .withClientBudgetMax(25)
                .withDepreciation(10)
                .withMaxClientsPerMonth(15)
                .withCarFactory(carFactory)
                .withClientFactory(clientFactory)
                .build();

        salon.carSupply();

        List<Car> cars = salon.getCars();

        Assertions.assertEquals(capacity, cars.size());
        Mockito.verify(carFactory, Mockito.times(capacity)).create(20, 30, 10);
    }

    @Test
    @DisplayName("Should deprecate price if car is already in cars list")
    void shouldDeprecatePrice() {
        CarFactory carFactory = Mockito.mock(CarFactory.class);
        Mockito.when(carFactory
                .create(500, 1500, 10))
                .thenAnswer(invocationOnMock -> new Car(1000, 100, "Van"));
        int capacity = 100;
        int depreciationPercent = 10;
        AutoDealership salon = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMin(500)
                .withCarPriceMax(1500)
                .withCapacity(capacity)
                .withMaxClientsPerMonth(10)
                .withCarFactory(carFactory)
                .withDepreciation(depreciationPercent)
                .build();

        salon.carSupply();
        salon.carSupply();
        Mockito.verify(carFactory, Mockito.times(capacity)).create(500, 1500, 10);
        Assertions.assertEquals(900, salon.getCars().get(9).getPrice());
    }

    @Test
    @DisplayName("Client list should be empty if all clients have bought a car")
    void clientListShouldBeEmpty() {
        ClientFactory clientFactory = Mockito.mock(ClientFactory.class);
        Mockito.when(clientFactory
                .create(500, 1500))
                .thenReturn(new Client(1000, "Van",
                        true, 0));
        AutoDealership salon = AutoDealershipBuilder.anAutoDealership()
                .withCarPriceMin(500)
                .withCarPriceMax(1500)
                .withMaxClientsPerMonth(10)
                .withCapacity(20)
                .withClientFactory(clientFactory)
                .build();
        salon.getCustomers().add(clientFactory.create(500, 1500));
        salon.getCustomers().add(clientFactory.create(500, 1500));
        salon.getCustomers().add(clientFactory.create(500, 1500));
        salon.getCustomers().add(clientFactory.create(500, 1500));
        salon.getCustomers().add(clientFactory.create(500, 1500));
        salon.clientListUpdate();
        Assertions.assertEquals(0, salon.getCustomers().size());
    }

    @Test
    @DisplayName("Should sell all cars this time")
    void shouldSellAllCarsFromAutodealership() {
        CarFactory carFactory = Mockito.mock(CarFactory.class);
        Mockito.when(carFactory.create(500, 1500, 10))
                .thenAnswer(s -> new Car(1000, 100, "Van"));
        ClientFactory clientFactory = Mockito.mock(ClientFactory.class);
        Mockito.when(clientFactory.create(500, 1500))
                .thenAnswer(s -> new Client(1000, "Van",
                        false, 0));

        AutoDealership rmFilipowicz = AutoDealershipBuilder.anAutoDealership()
                .withCapacity(10)
                .withCarFactory(carFactory)
                .withClientFactory(clientFactory)
                .withCarPriceMin(500)
                .withCarPriceMax(1500)
                .withClientBudgetMin(500)
                .withClientBudgetMax(1500)
                .withDepreciation(10)
                .withMaxClientsPerMonth(10)
                .build();
        rmFilipowicz.carSupply();
        int profit = rmFilipowicz.getMonthlyProfit();
        int howManyClientsVisited = rmFilipowicz.getCustomers().size();
        Assertions.assertEquals(howManyClientsVisited * 100, profit);
        /*
        Same as in shouldDeprecatePrice Test.
        Any operation conducted on any Mocked Car is applied to every Car object.
        That's why Test is passed when there was only 1 client, but not passed if more than that.
        */
    }
}