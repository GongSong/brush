package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.Bean;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.api.AccessTokenApi;

public class DyOpenConfiguration {
    @Bean
    public UserInfoApi userInfoApi(Request request){
        return new UserInfoApi(request);
    }

    @Bean
    public AccessTokenApi accessTokenApi (Request request, DyOpenConfig dyOpenConfig){
        return new AccessTokenApi(request, dyOpenConfig);
    }
}
