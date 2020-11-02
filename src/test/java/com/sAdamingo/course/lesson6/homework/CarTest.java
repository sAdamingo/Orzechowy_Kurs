package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {


    @Test
    void testGetProfit() {
    }

    @Test
    void testGetType() {
    }

    @Test
    void testGetPrice() {
    }

    @Test
    void testSetProfit() {
        //given
        int carPriceMin = 40;
        int carPriceMax = 30;
        //when
        Car multipla = new Car(carPriceMin, carPriceMax);
        //then
        boolean expectedValue = (multipla.getPrice() > carPriceMin && multipla.getPrice() < carPriceMax);
        assertTrue(expectedValue);
    }

    @Test
    void testSell() {
    }

    @Test
    void testIsSold() {
    }

    @Test
    void testDeprecatePrice() {
    }
}