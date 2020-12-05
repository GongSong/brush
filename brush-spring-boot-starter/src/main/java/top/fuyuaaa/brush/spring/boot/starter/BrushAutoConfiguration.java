package top.fuyuaaa.brush.spring.boot.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;

/**
 * dyOpen 自动配置
 * @author : fuyuaaa
 * @date : 2020-11-04 15:09
 */
@Configuration
@EnableConfigurationProperties(BrushProperties.class)
@ConditionalOnProperty(prefix = "brush.config", value = "enabled", matchIfMissing = true)
public class BrushAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DyOpenConfig dyOpenConfig(BrushProperties brushProperties) {
        return new DyOpenConfig(brushProperties.getDyOpenClientKey(),brushProperties.getDyOpenClientSecret());
    }
}
