package com.sAdamingo.course.Task18;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDecorator<T> implements DataBase {
    private DataBaseOperator<T> weakOperator;
    private
    LoadingCache<Long, T> fakeUserCache;


    public CacheDecorator(DataBaseOperator<T> weakOperatorr) {
        this.weakOperator = weakOperatorr;
        this.fakeUserCache = CacheBuilder.newBuilder()
                .maximumSize(20)                             // maximum 100 records can be cached
                .expireAfterAccess(30, TimeUnit.MINUTES)// cache will expire after 30 minutes of access
                .build(new CacheLoader<Long, T>() {  // build the cacheloader

                    @Override
                    public T load(Long userID) throws Exception {
                        return weakOperator.findById(userID);
                    }
                });
    }

    @Override

    public T findById(long id) throws IOException, ExecutionException {
        return fakeUserCache.get(id);
    }

    @Override
    public T getByJsonContainsWord(String wordInJson) throws IOException {
        return weakOperator.getByJsonContainsWord(wordInJson);
    }

    @Override
    public Long findObjectId(Object object) throws IOException {
        return weakOperator.findObjectId((T) object);
    }
}
