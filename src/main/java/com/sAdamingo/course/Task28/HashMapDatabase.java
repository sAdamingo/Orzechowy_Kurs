package com.sAdamingo.course.Task28;

import java.util.HashMap;
import java.util.Map;

public class HashMapDatabase implements Database<Book> {
    private final Map<String, Book> map = new HashMap<>();

    @Override
    public Book get(int id) {
        return map.get(Integer.toString(id));
    }

    @Override
    public void delete(int id) {
        map.remove(Integer.toString(id));
    }

    @Override
    public void add(Book obj) {
        map.put(Integer.toString(obj.getId()), obj);
    }
}
