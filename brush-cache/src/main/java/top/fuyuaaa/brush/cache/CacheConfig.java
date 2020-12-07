package top.fuyuaaa.brush.cache;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-12-07 16:34
 */
@Data
public class CacheConfig implements Serializable {
    private static final long serialVersionUID = -479285121290547573L;
    private boolean enable;
}
