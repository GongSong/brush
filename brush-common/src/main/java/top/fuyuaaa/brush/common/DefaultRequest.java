package top.fuyuaaa.brush.common;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import top.fuyuaaa.brush.common.error.ErrorCode;
import top.fuyuaaa.brush.common.error.RequestErrorException;
import top.fuyuaaa.brush.common.util.OkHttpUtil;

/**
 * @author : fuyuaaa
 * @date : 2020-09-28 14:09
 */
@Slf4j
public class DefaultRequest implements Request {

    /**
     * get请求
     *
     * @param url    请求url
     * @param tClass 类型
     * @return 返回数据
     */
    @Override
    public <T extends BaseData> T get(String url, Class<T> tClass) {
        String result = OkHttpUtil.get(url);
        RequestResult requestResult = JSON.parseObject(result, RequestResult.class);
        String data = requestResult.getData();
        T t = JSON.parseObject(data, tClass);
        Integer errorCode = t.getErrorCode();
        if (!ErrorCode.SUCCESS.getErrorCode().equals(errorCode)) {
            log.info("extra:{}", JSON.toJSONString(requestResult.getExtra()));
            throw new RequestErrorException(new BaseData(t.getErrorCode(), t.getDescription()));
        }
        return t;
    }

    /**
     * post请求
     *
     * @param url    请求url
     * @param json   参数
     * @param tClass 类型
     * @return 返回数据
     */
    @Override
    public <T extends BaseData> T post(String url, String json, Class<T> tClass) {
        return null;
    }

}
