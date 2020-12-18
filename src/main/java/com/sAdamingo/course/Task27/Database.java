/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sAdamingo.course.Task27;

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
