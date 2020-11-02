package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutoDealershipTest {

    @Test
    @DisplayName("Checking if carSupply method is smart enough")
    void carSupply() {
        //given
        List<Car> cars = new ArrayList<>();
        List<Client> customer = new ArrayList<>();

        //when
        int capacity = 20;
        AutoDealership rmFilipowicz = new AutoDealership(capacity, 10, 20
                , 50, 5, 15, 10, cars, customer);
        rmFilipowicz.carSupply();
        //then
        int expectedSize = cars.size();
        assertEquals(capacity, expectedSize);
    }

    @Test
    @DisplayName("Checking what happens when car price min is smaller than car price max")
    void carSupplyTest() {
        //given
        List<Car> cars = new ArrayList<>();
        List<Client> customer = new ArrayList<>();

        //when
        int carPriceMin = 30;
        int carPriceMax = 20;
        AutoDealership rmFilipowicz = new AutoDealership(20, carPriceMin, carPriceMax
                , 50, 5, 15, 10, cars, customer);
        rmFilipowicz.carSupply();
        //then
        int expectedValue = cars.get(1).getPrice();


    }


    @Test
    void clientListUpdate() {
    }

    @Test
    void getMonthlyProfit() {
    }
}