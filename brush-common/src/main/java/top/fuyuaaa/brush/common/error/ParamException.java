package top.fuyuaaa.brush.common.error;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 15:51
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = 8911613269584455910L;

    public ParamException(String error) {
        super(error);
    }
}
