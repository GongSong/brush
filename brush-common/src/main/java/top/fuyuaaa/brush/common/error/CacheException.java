package top.fuyuaaa.brush.common.error;

/**
 * 缓存异常
 *
 * @author : fuyuaaa
 * @date : 2020-12-07 09:46
 */
public class CacheException extends RuntimeException {
    private static final long serialVersionUID = 2440485591764299610L;

    public CacheException(String error) {
        super(error);
    }
}
