package top.fuyuaaa.brush.spring.boot.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 21:28
 */
@Validated
@Data
@ConfigurationProperties(prefix = "brush.config")
public class BrushProperties {

    @NotEmpty
    private String dyOpenClientKey;
    @NotEmpty
    private String dyOpenClientSecret;
}
