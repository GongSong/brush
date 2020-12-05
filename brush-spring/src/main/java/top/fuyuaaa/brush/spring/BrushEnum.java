package top.fuyuaaa.brush.spring;

import lombok.Getter;
import top.fuyuaaa.brush.dyopen.api.AccessTokenApi;
import top.fuyuaaa.brush.dyopen.api.UserInfoApi;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:16
 */
@Getter
public enum BrushEnum {
    /**
     * 抖音开放平台
     */
    DY_OPEN(BrushConstants.DY_OPEN_CODE, BrushConstants.DY_OPEN_BEANS),
    ;
    String code;
    String[] beans;


    BrushEnum(String code, String[] beans) {
        this.code = code;
        this.beans = beans;
    }

    public static BrushEnum find(String code) {
        for (BrushEnum brushEnum : BrushEnum.values()) {
            if (brushEnum.code.equals(code)) {
                return brushEnum;
            }
        }
        return null;
    }

    public interface BrushConstants {
        String DY_OPEN_CODE = "dyopen";




        String[] DY_OPEN_BEANS = new String[]{
                AccessTokenApi.class.getName(),
                UserInfoApi.class.getName()
        };
    }

}
