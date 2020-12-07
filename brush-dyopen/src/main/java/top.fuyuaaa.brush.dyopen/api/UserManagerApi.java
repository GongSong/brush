package top.fuyuaaa.brush.dyopen.api;

import lombok.AllArgsConstructor;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.common.util.UrlBuilder;
import top.fuyuaaa.brush.common.error.RequestErrorException;
import top.fuyuaaa.brush.dyopen.constant.DyOpenApiConstants;
import top.fuyuaaa.brush.dyopen.model.UserListResult;
import top.fuyuaaa.brush.dyopen.model.UserInfoResult;

/**
 * 用户管理api
 *
 * @author : fuyuaaa
 * @date : 2020-12-06 21:10
 */
@AllArgsConstructor
public class UserManagerApi {

    private final Request request;

    public UserInfoResult getUserInfo(String openId, String accessToken) throws RequestErrorException {
        String url = UrlBuilder.parseUrl(DyOpenApiConstants.USER_INFO, openId, accessToken);
        return request.get(url, UserInfoResult.class);
    }

    /**
     * 获取粉丝列表
     *
     * @param openId      授权者openId
     * @param accessToken token
     * @param cursor      游标
     * @param count       数量最多20
     * @return 粉丝列表
     */
    public UserListResult getFansList(String openId, String accessToken, Long cursor, Integer count) {
        String url = UrlBuilder.parseUrl(DyOpenApiConstants.FANS_LIST, openId, accessToken, cursor, count);
        return request.get(url, UserListResult.class);
    }

    public UserListResult getFollowingList(String openId, String accessToken, Long cursor, Integer count) {
        String url = UrlBuilder.parseUrl(DyOpenApiConstants.FOLLOWING_LIST, openId, accessToken, cursor, count);
        return request.get(url, UserListResult.class);
    }
}
