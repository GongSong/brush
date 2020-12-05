package top.fuyuaaa.brush.common.error;

import lombok.Getter;
import top.fuyuaaa.brush.common.BaseData;

/**
 * 
 * @author : fuyuaaa
 * @date : 2020-12-03 15:29
 */
public class RequestErrorException extends RuntimeException {
    private static final long serialVersionUID = -6357149550353160810L;

    @Getter
    private BaseData error;

    public RequestErrorException(BaseData error) {
        super(error.toString());
        this.error = error;
    }

    public RequestErrorException(BaseData error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }
}
