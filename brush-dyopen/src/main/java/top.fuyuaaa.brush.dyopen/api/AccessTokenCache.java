package top.fuyuaaa.brush.dyopen.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.fuyuaaa.brush.cache.Cache;
import top.fuyuaaa.brush.cache.CacheConfig;

/**
 * accessToken缓存
 *
 * @author : fuyuaaa
 * @date : 2020-12-07 16:39
 */
@Setter
@Getter
@Slf4j
@AllArgsConstructor
public class AccessTokenCache {

    private final Cache cache;
    private final CacheConfig cacheConfig;

    private final static String ACCESS_TOKEN_KEY_PREFIX = "accessToken:";
    private final static String REFRESH_TOKEN_KEY_PREFIX = "refreshToken:";

}
