package com.sAdamingo.course.Task22;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException {
        String path = "C:\\Users\\adam.stelmach\\Documents\\prywatne\\java\\Kurs Orzecha\\src\\main\\java\\com\\sAdamingo\\course\\Task22\\testowy.txt";
        DataBaseOperator<FakeUser> fakeUserDataBaseOperator = new DataBaseOperator<>(path, new FakeUser());
        CacheDecorator<FakeUser> fakeUserCacheDecorator = new CacheDecorator<FakeUser>(fakeUserDataBaseOperator);

        long now = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println(fakeUserDataBaseOperator.getByJsonContainsWord(new Faker().name().firstName()));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            System.out.println(fakeUserDataBaseOperator.findById(new Random().nextInt(199) + 1));
        }
        System.out.println("Execution time of weak operator [ms]: " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println(fakeUserCacheDecorator.getByJsonContainsWord(new Faker().name().firstName()));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            System.out.println(fakeUserCacheDecorator.findById(new Random().nextInt(199) + 1));
        }
        System.out.println("Execution time of cached operator [ms]: " + (System.currentTimeMillis() - now));
    }
}