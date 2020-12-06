package top.fuyuaaa.brush.dyopen.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.common.UrlBuilder;
import top.fuyuaaa.brush.common.error.RequestErrorException;
import top.fuyuaaa.brush.dyopen.model.AccessTokenResult;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.constant.DyOpenApiConstants;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 15:28
 */
@Getter
@Setter
@AllArgsConstructor
public class AccessTokenApi {

    private final Request request;
    private final DyOpenConfig config;

    public AccessTokenResult getAccessToken(String code) throws RequestErrorException {
        String url = UrlBuilder.parseUrl(DyOpenApiConstants.ACCESS_TOKEN, config.getClientKey(), config.getClientSecret(), code);
        return request.get(url, AccessTokenResult.class);
    }

}
