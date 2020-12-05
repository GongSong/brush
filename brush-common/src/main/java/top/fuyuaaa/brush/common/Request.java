package top.fuyuaaa.brush.common;

/**
 * @author : fuyuaaa
 * @date : 2020-09-28 13:42
 */
public interface Request {
    /**
     * get请求
     *
     * @param url    请求url
     * @param tClass 类型
     * @return 返回数据
     */
    <T extends BaseData> T get(String url, Class<T> tClass);

    /**
     * post请求
     *
     * @param url    请求url
     * @param json   参数
     * @param tClass 类型
     * @return 返回数据
     */
    <T extends BaseData> T post(String url, String json, Class<T> tClass);

}
