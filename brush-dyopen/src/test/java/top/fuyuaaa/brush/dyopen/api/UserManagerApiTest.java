package top.fuyuaaa.brush.dyopen.api;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import top.fuyuaaa.brush.common.DefaultRequest;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.dyopen.model.UserListResult;
import top.fuyuaaa.brush.dyopen.model.UserInfoResult;

public class UserManagerApiTest {

    private UserManagerApi userManagerApi;
    String openId = "9b7351be-29d1-412a-99d2-54e1e64e2340";
    String accessToken = "act.a37e2c9b55c4bae60115d887da80bf90HVIa5dtCf543BWv9D7u5uXPGESwE";

    {
        Request request = new DefaultRequest();
        userManagerApi = new UserManagerApi(request);
    }


    @Test
    public void getUserInfo() {
        UserInfoResult userInfo = userManagerApi.getUserInfo(openId, accessToken);
        System.out.println(JSON.toJSONString(userInfo));

    }

    @Test
    public void getFansList() {
        UserListResult fansList = userManagerApi.getFansList(openId, accessToken, 0L, 20);
        System.out.println(JSON.toJSONString(fansList));
    }

    @Test
    public void getFollowingList() {
        UserListResult followingList = userManagerApi.getFollowingList(openId, accessToken, 0L, 20);
        System.out.println(JSON.toJSONString(followingList));
    }
}