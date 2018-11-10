package com.gt.esp.config.handlerfilter;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 创建时间：2018年/11月/10日
 *
 * @author 张政[zhang_zheng@sinosoft.com.cn]
 * 类名：FilterConfigurer
 * 描述：当需要处理跨域时可再次配置
 */
@Configuration
public class FilterConfigurer {

    @Bean
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "local")
    public CorsFilter corsFilterLocal() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }


    /**
     * 对CorsConfiguration的配置
     *
     * @return 返回CorsConfiguration
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
}
