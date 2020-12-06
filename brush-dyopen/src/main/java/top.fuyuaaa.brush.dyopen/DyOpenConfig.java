package top.fuyuaaa.brush.dyopen;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 抖音开放平台-应用相关配置
 *
 * @author : fuyuaaa
 * @date : 2020-12-03 15:56
 */
@Data
@AllArgsConstructor
public class DyOpenConfig {
    private String clientKey;
    private String clientSecret;
}
