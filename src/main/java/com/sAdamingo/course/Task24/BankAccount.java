package com.sAdamingo.course.Task24;

import java.util.LinkedList;
import java.util.List;

public class BankAccount {
    private double currentBallance;
    private List<Operation> operationHistory;

    public BankAccount(double currentBallance) {
        this.currentBallance = currentBallance;
        this.operationHistory = new LinkedList<>();
    }

    double getBalance() {
        return currentBallance;
    }

    List<Operation> getLastOperations(int n) {
        if (operationHistory.size() >= n) {
            return operationHistory.subList(operationHistory.size() - n, operationHistory.size());
        } else {
            return operationHistory;
        }
    }

    void deposit(double amount, String name) {
        if (amount > 0) {
            currentBallance += amount;
            operationHistory.add(new Operation(amount, name));
        } else {
            System.out.println("To subtract money from account, you should Rather use withdraw option");
        }
    }

    void withdraw(double amount, String name) {
        if (currentBallance >= amount) {
            currentBallance -= amount;
            operationHistory.add(new Operation(amount, name));
        } else {
            System.out.println("Not enough" +
                    " money.");
        }
    }
}