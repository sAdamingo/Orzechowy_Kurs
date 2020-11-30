package com.sAdamingo.course.Task18;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException {
        String path = "C:\\Users\\adam.stelmach\\Documents\\prywatne\\java\\Kurs Orzecha\\src\\main\\java\\com\\sAdamingo\\course\\Task18\\testowy.txt";
        DataBase<FakeUser> fakeUserDataBaseOperator = new DataBaseOperator<>(path);
        DataBase<FakeUser> fakeUserCacheDecorator = new CacheDecorator<FakeUser>((DataBaseOperator<FakeUser>) fakeUserDataBaseOperator);
        long now = LocalTime.now().toNanoOfDay();

        for (int i = 0; i < 50; i++) {
            try {
                fakeUserDataBaseOperator.getByJsonContainsWord(new Faker().name().firstName());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            System.out.println(fakeUserDataBaseOperator.findById(150L));
        }
        System.out.println(now - LocalTime.now().toNanoOfDay());
        now = LocalTime.now().toNanoOfDay();
        for (int i = 0; i < 50; i++) {
            try {
                fakeUserCacheDecorator.getByJsonContainsWord(new Faker().name().firstName());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            fakeUserCacheDecorator.findById(150L);
        }
        System.out.println(now - LocalTime.now().toNanoOfDay());
    }
}