package top.fuyuaaa.brush.common.error;

import lombok.Getter;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 14:59
 */
@Getter
public enum ErrorCode {
    /**
     * success
     */
    SUCCESS(0, "success"),
    INVALID_ACCESS_TOKEN(10008, "无效access_token"),
    PARAMETER_ERROR(2100005, "Parameter error"),
    ;

    Integer errorCode;
    String description;

    ErrorCode(Integer errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
