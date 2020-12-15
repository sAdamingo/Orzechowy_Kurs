package com.sAdamingo.course.Task24;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BankingDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        Thread withdrawer = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            bankAccount.withdraw(new Random().nextDouble() * 1000, "Withdrawer withdrawing");
                            try {
                                bankAccount.wait(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                , "withdrawer");

        Thread depositer = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            bankAccount.deposit(new Random().nextDouble() * 1000, "Depositer depositing");
                            try {
                                bankAccount.wait(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                "depositer");
        Thread checker = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            int randomInt = new Random().nextInt(9);
                            List<Operation> lastOperations = bankAccount.getLastOperations(randomInt + 1);
                            System.out.println("Last " + (randomInt + 1) + " operations are : " + lastOperations.stream()
                                    .map(Operation::toString).collect(Collectors.joining(", ")));
                            try {
                                bankAccount.wait(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                "checker");

        withdrawer.start();
        depositer.start();
        checker.start();
    }
}
