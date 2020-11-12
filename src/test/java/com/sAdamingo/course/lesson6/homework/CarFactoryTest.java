package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    private CarFactory carFactory = new CarFactory();

    @Test
    @DisplayName("What if carPriceMax is smaller than carPriceMin?")
    void shouldThrowIllegalArgumentException() {
        int carPriceMin = 10;
        int carPriceMax = 5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carFactory.create(carPriceMin, carPriceMax, 10);
        });
    }
}