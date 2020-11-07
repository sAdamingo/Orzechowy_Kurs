package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("Profit is in dedicated range??")
    void shouldGetProfit() {
        int carPriceMin = 20;
        int carPriceMax = 20;

        Car auto = new Car(carPriceMin, carPriceMax);
        boolean isInRange = (auto.getPrice() >= carPriceMin && auto.getPrice() <= carPriceMax);
        assertTrue(isInRange);
    }

    @Test
    @DisplayName("What if car price min and max are equal?")
    void carPriceMinAndMaxAreEqual() {
        int carPriceMin = 20;
        int carPriceMax = 20;

        Car auto = new Car(carPriceMin, carPriceMax);
        boolean isInRange = (auto.getPrice() >= carPriceMin && auto.getPrice() <= carPriceMax);
        assertTrue(isInRange);
    }

    @Test
    @DisplayName("Test if budget returns exception when min > max")
    void shouldThrowExceptionWhenMinGreaterThanMax() {
        int budgetMin = 120;
        int budgetMax = 100;
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(budgetMin, budgetMax);
        });
    }

    @Test
    @DisplayName("Check if Depreciation works correct")
    void checkDepreciation() {
        Car escort = new Car(5, 10);
        int priceBefore = escort.getPrice();
        int depreciationPercent = 10;
        escort.deprecatePrice(depreciationPercent);
        int priceAfter = escort.getPrice();
        int depreciationValue = priceBefore - priceAfter;
        assertEquals(depreciationValue,
                priceBefore * depreciationPercent / 100);
    }

    @Test
    @DisplayName("Check if profit depreciation works correct")
    void checkProfitDepreciation() {
        Car escort = new Car(5, 10);
        int profitBefore = escort.getProfit();
        int priceBefore = escort.getPrice();
        int depreciationPercent = 100;
        escort.deprecatePrice(depreciationPercent);
        int profitAfter = escort.getProfit();
        int depreciationValue = profitBefore - (priceBefore * depreciationPercent / 100);
        assertEquals(profitAfter,
                depreciationValue);
    }

    @Test
    @DisplayName("Check when depreciation percent is eqal to 0")
    void checkIfDepreciationIsZero() {
        Car escort = new Car(5, 10);
        int profitBefore = escort.getProfit();
        int priceBefore = escort.getPrice();
        int depreciationPercent = 0;
        escort.deprecatePrice(depreciationPercent);
        int profitAfter = escort.getProfit();
        int priceAfter = escort.getPrice();

        assertEquals(profitBefore, profitAfter);
        assertEquals(priceBefore, priceAfter);
    }
}