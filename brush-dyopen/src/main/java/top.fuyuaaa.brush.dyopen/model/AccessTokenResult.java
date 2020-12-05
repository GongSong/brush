package top.fuyuaaa.brush.dyopen.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.fuyuaaa.brush.common.BaseData;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-10-21 09:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccessTokenResult extends BaseData implements Serializable {

    private static final long serialVersionUID = 649889641349441113L;

    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private String expiresIn;

    @JSONField(name = "open_id")
    private String openId;

    @JSONField(name = "refresh_token")
    private String refreshToken;

    private String scope;

    @JSONField(name = "unionid")
    private String unionId;

}
