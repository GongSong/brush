package top.fuyuaaa.brush.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 14:58
 */
@Data
public class BaseData implements Serializable {
    private static final long serialVersionUID = 7309307628663444682L;
    @JSONField(name = "error_code")
    private Integer errorCode;
    private String description;
}
