package top.fuyuaaa.brush.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 15:04
 */
@Data
@SuppressWarnings("all")
public class Extra implements Serializable {

    private static final long serialVersionUID = 3958399828578566583L;
    private long now;
    private String logid;
}
