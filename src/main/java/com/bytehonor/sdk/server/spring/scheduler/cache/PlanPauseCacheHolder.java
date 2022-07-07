package com.bytehonor.sdk.server.spring.scheduler.cache;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class PlanPauseCacheHolder {

    private static int CAPACITY = 512;

    private static Cache<String, Boolean> CACHE = CacheBuilder.newBuilder().initialCapacity(CAPACITY) // 设置初始容量为100
            .maximumSize(10 * CAPACITY) // 设置缓存的最大容量
            .expireAfterWrite(12, TimeUnit.HOURS) // 设置缓存在写入一分钟后失效
            .concurrencyLevel(20) // 设置并发级别为10
            .build(); // .recordStats() // 开启缓存统计

    public static void put(String key, Boolean value) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(value, "value");
        CACHE.put(key, value);
    }

    public static Boolean getIfPresent(String key) {
        Objects.requireNonNull(key, "key");
        return CACHE.getIfPresent(key);
    }

    public static void invalidate(String key) {
        Objects.requireNonNull(key, "key");
        CACHE.invalidate(key);
    }

    public static void stop(String name) {
        put(name, true);
    }

    public static void start(String name) {
        invalidate(name);
    }

    public static boolean isPause(String name) {
        return getIfPresent(name) != null;
    }
}
