package top.fuyuaaa.brush.cache;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import top.fuyuaaa.brush.common.error.CacheException;
import top.fuyuaaa.brush.common.error.UnsupportedException;

import java.util.concurrent.TimeUnit;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 09:42
 */
@Slf4j
public abstract class AbstractCache implements Cache {

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if (StrUtil.isEmpty(key)) {
            throw new CacheException("key cant't be empty");
        }
        return doGet(buildKey(key), clazz);
    }

    /**
     * set cache
     *
     * @param key   cacheKey
     * @param value cacheValue
     */
    @Override
    public void set(String key, Object value) {
        doSet(buildKey(key), value);
    }

    @Override
    public void set(String key, Object value, long expire) {
        set(buildKey(key), value, expire, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        if (StrUtil.isEmpty(key)) {
            throw new CacheException("key cant't be empty");
        }
        doSet(buildKey(key), value, expire, timeUnit);
    }

    @Override
    public void delete(String key) {
        if (StrUtil.isEmpty(key)) {
            throw new CacheException("key cant't be empty");
        }
        doDelete(buildKey(key));
    }

    private String buildKey(String key) {
        return key.startsWith("brush:") ? key : "brush:" + key;
    }

    /**
     * get cache value
     *
     * @param key   cache key
     * @param clazz value type
     * @return cache value
     */
    protected <T> T doGet(String key, Class<T> clazz) {
        throw new UnsupportedException("unsupported method when using this cache");
    }


    /**
     * set cache value with unit
     *
     * @param key   cache key
     * @param value cache value
     */
    protected void doSet(String key, Object value) {
        throw new UnsupportedException("unsupported method when using this cache");
    }

    /**
     * set cache value with unit
     *
     * @param key      cache key
     * @param value    cache value
     * @param expire   cache expire
     * @param timeUnit cache expire timeUnit
     */
    protected void doSet(String key, Object value, long expire, TimeUnit timeUnit) {
        throw new UnsupportedException("unsupported method when using this cache");
    }


    /**
     * get cache value
     *
     * @param key cache key
     */
    protected void doDelete(String key) {
        throw new UnsupportedException("unsupported method when using this cache");
    }

}
