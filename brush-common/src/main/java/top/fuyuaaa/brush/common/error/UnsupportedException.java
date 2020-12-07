package top.fuyuaaa.brush.common.error;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 10:02
 */
public class UnsupportedException extends RuntimeException {
    private static final long serialVersionUID = 2440485591764299610L;

    public UnsupportedException(String error) {
        super(error);
    }
}