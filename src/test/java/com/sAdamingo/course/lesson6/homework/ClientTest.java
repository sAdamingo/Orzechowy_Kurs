package com.sAdamingo.course.lesson6.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private ClientFactory clientFactory;

    @Test
    @DisplayName("Test if budget is set ok when budget max = budget min")
    void checkBugetSetterWhenEquals() {
        int budgetMin = 100;
        int budgetMax = 100;
        Client customer = clientFactory.create(budgetMin, budgetMax);
        assertEquals(100, customer.getBudget());
    }

    @Test
    @DisplayName("Test if budget returns exception when min > max")
    void shouldThrowExceptionWhenMinGreaterThanMax() {
        int budgetMin = 120;
        int budgetMax = 100;
        assertThrows(IllegalArgumentException.class, () -> {
            clientFactory.create(budgetMin, budgetMax);
        });
    }

    @Test
    @DisplayName("Check if budget is in range")
    void budgetShouldBeInRange() {
        int budgetMin = 80;
        int budgetMax = 100;
        Client adamSkladowy = clientFactory.create(budgetMin, budgetMax);
        boolean isBudgetInRange = (adamSkladowy.getBudget() >= budgetMin
                && adamSkladowy.getBudget() <= budgetMax);
        assertTrue(isBudgetInRange);
    }
}