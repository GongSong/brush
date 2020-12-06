package top.fuyuaaa.brush.spring;

import lombok.Getter;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:16
 */
@Getter
public enum BrushEnum {
    /**
     * 抖音开放平台
     */
    DY_OPEN(BrushConstants.DY_OPEN_CODE, DyOpenConfiguration.class.getName()),
    ;
    String code;
    String bean;

    BrushEnum(String code, String bean) {
        this.code = code;
        this.bean = bean;
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
    }

}
