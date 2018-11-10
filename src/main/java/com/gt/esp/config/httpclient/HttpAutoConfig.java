package com.gt.esp.config.httpclient;

import com.gt.esp.util.http.HttpUtils;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 创建时间：2018年/11月/10日
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：HttpAutoConfig
 * 描述：配置HTTP请求
 */
@Configuration
public class HttpAutoConfig {
    @Bean
    public HttpUtils okHttpClient() {
        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        return new HttpUtils(build);
    }
}
