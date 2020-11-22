package com.sAdamingo.course.Task18;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DataBaseOperator {


    public static void main(String[] args) throws ExecutionException, IOException, ParseException {
        System.out.println("Welcome to DataBase Operator!");

        LoadingCache<String, FakeUser> fakeUsersCache = createCache();

        System.out.println(getByID(fakeUsersCache, "3").printUserData());
        System.out.println(getByID(fakeUsersCache, "33").printUserData());
        System.out.println(getByID(fakeUsersCache, "345").printUserData());
        System.out.println(getByID(fakeUsersCache, "369").printUserData());
        System.out.println(getByID(fakeUsersCache, "763").printUserData());
        System.out.println(getByID(fakeUsersCache, "553").printUserData());
        System.out.println(getByID(fakeUsersCache, "993").printUserData());
        new JSonReader().addFakeUserToFile("993");
        System.out.println(getByID(fakeUsersCache, "993").printUserData());
        // Here the case is even more complicated, because the cache do not know if the cache was changed ;(

    }

    public static LoadingCache<String, FakeUser> createCache() {
        return CacheBuilder.newBuilder()
                .maximumSize(5)                             // maximum 5 records can be cached
                .expireAfterAccess(30, TimeUnit.MINUTES)      // cache will expire after 30 minutes of access
                .build(new CacheLoader<String, FakeUser>() {  // build the cacheloader

                    @Override
                    public FakeUser load(String userId) throws Exception {
                        JSonReader addagio = new JSonReader();
                        FakeUser user = addagio.readJSONFileFullOfFakeUsers()
                                .stream()
                                .filter(s -> s.getId().equals(userId))
                                .collect(toSingleton());
                        return user;
                    }
                });
    }

    private static FakeUser getByID(LoadingCache fakeUsersCache, String id) throws ExecutionException {
        return (FakeUser) fakeUsersCache.get(id);
    }

/*    private String find(String searchedText) {

    }*/

    private void add(String textToAdd) throws IOException, ParseException {
        new JSonReader().addFakeUserToFile("456");
    }

    private void delete(int id) {

    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() == 0) {
                        throw new IllegalArgumentException("No such ID");
                    } else if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }
}