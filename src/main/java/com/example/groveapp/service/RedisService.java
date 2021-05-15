package com.example.groveapp.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    void set(String key, Object value);

    Object get(String key);

    public void set(String key, Object value, long timeOut, TimeUnit unit);
}