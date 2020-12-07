package top.fuyuaaa.brush.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 09:36
 */
public interface Cache {

    /**
     * get cache value
     *
     * @param key  cache key
     * @param type class type
     * @param <T>  type
     * @return cache value
     */
    <T> T get(String key, Class<T> type);

    /**
     * set cache
     *
     * @param key   cacheKey
     * @param value cacheValue
     */
    void set(String key, Object value);


    /**
     * set cache
     *
     * @param key    cache key
     * @param value  cache value
     * @param expire cache expire , unit -> second
     */
    void set(String key, Object value, long expire);

    /**
     * set cache value with unit
     *
     * @param key      cache key
     * @param value    cache value
     * @param expire   cache expire
     * @param timeUnit cache expire timeUnit
     */
    void set(String key, Object value, long expire, TimeUnit timeUnit);

    /**
     * delete cache
     *
     * @param key cache key
     */
    void delete(String key);
}
