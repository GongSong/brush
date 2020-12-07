package top.fuyuaaa.brush.dyopen.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.codec.binary.Base64;
import top.fuyuaaa.brush.common.util.AES;
import top.fuyuaaa.brush.common.BaseData;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
/**
 * 抖音授权用户信息
 *
 * @author : fuyuaaa
 * @date : 2020-11-02 14:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResult extends BaseData implements Serializable {

    private static final long serialVersionUID = 5684669773554078678L;
    /**
     * 用户在当前开发者账号下的唯一标识（未绑定开发者账号没有该字段）
     */
    @JSONField(name = "union_id")
    private String unionId;

    /**
     * 用户在当前应用的唯一标识
     */
    @JSONField(name = "open_id")
    private String openId;

    /**
     * 用户名
     */
    private String nickname;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 类型: * `EAccountM` - 普通企业号 * `EAccountS` - 认证企业号 * `EAccountK` - 品牌企业号
     */
    @JSONField(name = "e_account_role")
    private String eAccountRole;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 性别: * `0` - 未知 * `1` - 男性 * `2` - 女性
     */
    private Integer gender;

    /**
     * 手机号加密数据
     */
    @JSONField(name = "encrypt_mobile")
    private String encryptMobile;
    /**
     * 手机号，根据encrypt_mobile解密出来的
     */
    private String phone;


    public void decryptPhone(String clientSecret) {
        String encryptMobile = this.encryptMobile;
        byte[] origData = Base64.decodeBase64(encryptMobile);
        byte[] key = clientSecret.getBytes();
        byte[] iv = Arrays.copyOf(key, 16);
        AES aes = new AES();
        try {
            byte[] phoneByte = aes.decrypt(origData, key, iv);
            this.phone = new String(phoneByte);
        } catch (InvalidAlgorithmParameterException ignore) {
        }
    }
}
