package com.sAdamingo.course.Task22;

import com.github.javafaker.Faker;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class FakeUser {

    private final String name;
    private final String password;
    private final int phoneNumber;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public FakeUser(String name, String password, int phoneNumber) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public FakeUser() {
        Faker names = new Faker();
        this.name = names.name().firstName();
        this.password = UUID.randomUUID().toString();
        this.phoneNumber = 600000000 + new Random().nextInt(99_999_999);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FakeUser fakeUser = (FakeUser) o;
        return phoneNumber == fakeUser.phoneNumber
                && Objects.equals(name, fakeUser.name)
                && Objects.equals(password, fakeUser.password);
    }

    @Override
    public String toString() {
        return "FakeUser{" +
                "userName=" + name +
                ", password='" + password + "', phone number='" + phoneNumber + '\'' +
                '}';
    }
}