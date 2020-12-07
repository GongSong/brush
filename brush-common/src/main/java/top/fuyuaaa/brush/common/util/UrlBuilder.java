package top.fuyuaaa.brush.common.util;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 15:50
 */
public class UrlBuilder {
    public static String parseUrl(String url, Object... params) {
        return String.format(url, params);
    }
}
