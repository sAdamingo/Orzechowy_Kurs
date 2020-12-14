package com.sAdamingo.course.Task26;

import java.util.List;

/**
 * @author Orzech
 */
public interface Database<T> {

    List<T> getAll();

    T get(String id);

    void update(T obj);

    void delete(String id);

    void add(T obj);
}