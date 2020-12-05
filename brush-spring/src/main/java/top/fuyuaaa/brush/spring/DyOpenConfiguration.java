package top.fuyuaaa.brush.spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;

/**
 * @author : fuyuaaa
 * @date : 2020-12-04 17:49
 */
public class DyOpenConfiguration {

    @Value("${type.config.dyOpenClientKey}")
    String clientKey;
    @Value("${type.config.dyOpenClientSecret}")
    String clientSecret;

    @Bean
    public DyOpenConfig dyOpenConfig() {
        if (StringUtils.isAnyBlank(clientKey, clientSecret)
                || StringUtils.equals(clientKey,"${type.config.dyOpenClientKey}")
                || StringUtils.equals(clientSecret,"${type.config.dyOpenClientSecret}")
        ) {
            throw new IllegalArgumentException("config is error or empty");
        }
        return new DyOpenConfig(clientKey, clientSecret);
    }
}
