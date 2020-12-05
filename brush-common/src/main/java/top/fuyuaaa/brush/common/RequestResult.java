package top.fuyuaaa.brush.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 14:54
 */
@Data
public class RequestResult implements Serializable {
    private static final long serialVersionUID = -4574633667756422519L;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "data")
    private String data;

    @JSONField(name = "extra")
    private Extra extra;
}
