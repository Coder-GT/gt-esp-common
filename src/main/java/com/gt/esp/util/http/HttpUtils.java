package com.gt.esp.util.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

/**
 * 创建时间：2018/六月/08
 *
 * @author 张政[zhang_zheng@gt.com.cn]
 * 类名：HttpUtils
 * 描述：HttpUtils
 */
@Slf4j
public class HttpUtils {
    private OkHttpClient okHttpClient;

    public HttpUtils(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public Object call(String url, Class clazz) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body != null) {
                return JSONObject.parseObject(body.string(), clazz);
            } else {
                return null;
            }
        } catch (Exception e) {
            log.warn(url + ", " + e.getMessage());
            return null;
        }
    }
}
