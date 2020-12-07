package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.Bean;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.api.AccessTokenApi;
import top.fuyuaaa.brush.dyopen.api.UserManagerApi;

/**
 *
 * @author : fuyuaaa
 * @date : 2020-12-07 10:40
 */
public class DyOpenConfiguration {
    @Bean
    public UserManagerApi userManagerApi(Request request) {
        return new UserManagerApi(request);
    }

    @Bean
    public AccessTokenApi accessTokenApi(Request request, DyOpenConfig dyOpenConfig) {
        return new AccessTokenApi(request, dyOpenConfig);
    }
}
