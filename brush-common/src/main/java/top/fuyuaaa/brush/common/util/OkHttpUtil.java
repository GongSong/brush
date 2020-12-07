package top.fuyuaaa.brush.common.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author : fuyuaaa
 * @date : 2020-12-03 15:06
 */
@Slf4j
public class OkHttpUtil {

    private static final OkHttpClient CLIENT = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).build();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String get(String url) {
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String post(String url, String json) {
        return postJson(url, json, null);
    }

    public static String postJson(String url, String json, Map<String, Object> headers) {
        okhttp3.Request request = requestBuilder(url, json, headers);
        try (Response response = CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static okhttp3.Request requestBuilder(String url, String json, Map<String, Object> headers) {
        RequestBody body = RequestBody.create(JSON, json);
        okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
            .url(url)
            .post(body);

        if (null != headers && headers.size() != 0) {
            for (String key : headers.keySet()) {
                requestBuilder.header(key, String.valueOf(headers.get(key)));
            }
        }

        return requestBuilder.build();
    }

}
