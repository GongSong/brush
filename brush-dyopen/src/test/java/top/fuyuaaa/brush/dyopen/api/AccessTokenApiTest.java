package top.fuyuaaa.brush.dyopen.api;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import top.fuyuaaa.brush.common.DefaultRequest;
import top.fuyuaaa.brush.common.Request;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.model.AccessTokenResult;

import static org.junit.Assert.*;

public class AccessTokenApiTest {

    private AccessTokenApi accessTokenApi;
    private String refreshToken="rft.41da9178dd2ef6280a0230985a6e14688J4sABH0HfGGRgheyr71XOelw5wM";
    {
        Request request = new DefaultRequest();
        DyOpenConfig dyOpenConfig = new DyOpenConfig("awcquhkwk941h40z","2aa288f7a125ec765f3e91cac5bad0f8");
        accessTokenApi = new AccessTokenApi(request,dyOpenConfig);
    }

    @Test
    public void platformOauthConnect() {
        String url = accessTokenApi.platformOauthConnect("user_info,fans.list,following.list", "https://da-vinci.proxy.dasouche.com/api");
        System.out.println(url);
    }

    @Test
    public void getAccessToken() {
        AccessTokenResult accessTokenResult = accessTokenApi.getAccessToken("pnMahztimjbeJMaURJ3WQ3xYASPyqituRCjP");
        System.out.println(JSON.toJSONString(accessTokenResult));
    }

    @Test
    public void refreshAccessToken(){
        AccessTokenResult accessTokenResult = accessTokenApi.refreshAccessToken(refreshToken);
        System.out.println(JSON.toJSONString(accessTokenResult));
    }

    @Test
    public void renewRefreshToken(){
        AccessTokenResult accessTokenResult = accessTokenApi.renewRefreshToken(refreshToken);
        System.out.println(JSON.toJSONString(accessTokenResult));
    }
}