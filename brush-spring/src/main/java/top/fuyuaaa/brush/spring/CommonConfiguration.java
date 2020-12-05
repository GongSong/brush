package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import top.fuyuaaa.brush.common.DefaultRequest;
import top.fuyuaaa.brush.common.Request;

public class CommonConfiguration {
    @Bean
    @Conditional(DefaultRequestCondition.class)
    public Request request(){
        return new DefaultRequest();
    }
}
