package top.fuyuaaa.brush.cache;

import cn.hutool.cache.impl.TimedCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 10:01
 */
@Slf4j
public class LocalCache extends AbstractCache {

    @SuppressWarnings("unchecked")
    private final static TimedCache<String, Object> CACHE = new TimedCache<>(60);


    /**
     * get cache value
     *
     * @param key   cache key
     * @param clazz value type
     * @return cache value
     */
    @Override
    @SuppressWarnings("unchecked")
    protected <T> T doGet(String key, Class<T> clazz) {
        Object value = CACHE.get(key, false);
        if (null == value) {
            return null;
        }
        try {
            return (T) value;
        } catch (Exception e) {
            log.error("Serialization error, key:{},value:{},class:{}", key, value, clazz, e);
            return null;
        }
    }

    /**
     * set cache value with unit
     *
     * @param key      cache key
     * @param value    cache value
     * @param expire   cache expire
     * @param timeUnit cache expire timeUnit
     */
    @Override
    protected void doSet(String key, Object value, long expire, TimeUnit timeUnit) {
        CACHE.put(key, value, timeUnit.toMillis(expire));
    }

    /**
     * set cache value with unit
     *
     * @param key   cache key
     * @param value cache value
     */
    @Override
    protected void doSet(String key, Object value) {
        CACHE.put(key, value, Long.MAX_VALUE);
    }

    /**
     * get cache value
     *
     * @param key cache key
     */
    @Override
    protected void doDelete(String key) {
        CACHE.remove(key);
    }
}
