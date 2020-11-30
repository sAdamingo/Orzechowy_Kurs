package com.sAdamingo.course.Task22;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface DataBase<T> {
    T findById(long id) throws IOException, ExecutionException;

    T getByJsonContainsWord(String wordInJson) throws IOException;

    Long findObjectId(T object) throws IOException;
}