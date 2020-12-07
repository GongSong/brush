package top.fuyuaaa.brush.common.error;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 09:47
 */
public class SerializationException extends RuntimeException {
    private static final long serialVersionUID = 2440485591764299610L;

    public SerializationException(String error) {
        super(error);
    }
}
