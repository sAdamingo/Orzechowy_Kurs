package com.sAdamingo.course.Task18;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException {
        String path = args[0];
        CacheDecorator<FakeUser> fakeUserCacheDecorator = new CacheDecorator<>();
        DataBaseOperator<FakeUser> fakeUserDataBaseOperator = new DataBaseOperator<>(path);
    }
}