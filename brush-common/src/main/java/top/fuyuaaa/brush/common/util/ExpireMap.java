package top.fuyuaaa.brush.common.util;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 10:34
 */
public class ExpireMap<K, V> extends ConcurrentHashMap<K, V> {
    private static final long serialVersionUID = 1L;

    private long defaultExpire = 1000 * 2;

    private ConcurrentHashMap<K, Long> expiryMap = new ConcurrentHashMap<>();

    private volatile static ExpireMap expireMap;

    public static ExpireMap getInstance() {
        if (null == expireMap) {
            synchronized (ExpireMap.class) {
                if (null == expireMap) {
                    expireMap = new ExpireMap<>();
                }
            }
        }
        return expireMap;
    }

    public ExpireMap() {
        super();
    }

    public ExpireMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ExpireMap(long defaultExpiryTime) {
        this(1 << 4, defaultExpiryTime);
    }

    public ExpireMap(int initialCapacity, long defaultExpiryTime) {
        super(initialCapacity);
        this.defaultExpire = defaultExpiryTime;
    }

    @Override
    public V put(@NotNull K key, @NotNull V value) {
        expiryMap.put(key, System.currentTimeMillis() + defaultExpire);
        return super.put(key, value);
    }

    @Override
    public boolean containsKey(Object key) {
        return !checkExpiry(key, true) && super.containsKey(key);
    }

    /**
     * @param key        key
     * @param value      value
     * @param expiryTime 键值对有效期 毫秒
     * @return value
     */
    public V put(K key, V value, long expiryTime) {
        expiryMap.put(key, System.currentTimeMillis() + expiryTime);
        return super.put(key, value);
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return entrySet().size() == 0;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        Set<Entry<K, V>> set = super.entrySet();
        Iterator<Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext()) {
            java.util.Map.Entry<K, V> entry = iterator.next();
            if (value.equals(entry.getValue())) {
                if (checkExpiry(entry.getKey(), false)) {
                    iterator.remove();
                    return Boolean.FALSE;
                } else {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Collection<V> values() {

        Collection<V> values = super.values();

        if (values.size() < 1) {
            return values;
        }

        values.removeIf(next -> !containsValue(next));
        return values;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        if (checkExpiry(key, true)) {
            return null;
        }
        return super.get(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            expiryMap.put(e.getKey(), System.currentTimeMillis() + defaultExpire);
        }
        super.putAll(m);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<java.util.Map.Entry<K, V>> set = super.entrySet();
        set.removeIf(entry -> checkExpiry(entry.getKey(), false));
        return set;
    }

    private boolean checkExpiry(Object key, boolean isRemoveSuper) {

        if (!expiryMap.containsKey(key)) {
            return Boolean.FALSE;
        }
        long expiryTime = expiryMap.get(key);

        boolean flag = System.currentTimeMillis() > expiryTime;

        if (flag) {
            if (isRemoveSuper) {
                super.remove(key);
            }
            expiryMap.remove(key);
        }
        return flag;
    }

}
