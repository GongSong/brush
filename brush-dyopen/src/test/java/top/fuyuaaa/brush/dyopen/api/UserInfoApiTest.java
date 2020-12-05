package top.fuyuaaa.brush.dyopen.api;

import org.junit.Assert;
import org.junit.Test;
import top.fuyuaaa.brush.common.DefaultRequest;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.dyopen.model.UserInfoResult;

public class UserInfoApiTest {

    private UserInfoApi userInfoApi;
    String openId = "e51b8321-564c-4ec4-b027-22d22902fb8d";
    String accessToken = "act.68d88f96ef2c7c6851c287c9a82ae269BFmvoXzOojk11ZtdqlKqrFuIXEkm";

    {
        Request request = new DefaultRequest();
        userInfoApi = new UserInfoApi(request);
    }

    @Test
    public void getUserInfo() {
        UserInfoResult userInfo = userInfoApi.getUserInfo(openId, accessToken);
        Assert.assertNotNull(userInfo);
    }
}