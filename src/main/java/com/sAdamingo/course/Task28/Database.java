package com.sAdamingo.course.Task28;

public interface Database<T> {

    T get(int id);

    void delete(int id);

    void add(T obj);
}