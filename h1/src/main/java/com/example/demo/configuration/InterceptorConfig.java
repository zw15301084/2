package com.example.demo.configuration;

import com.example.demo.interceptors.URLInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/为前缀的 url路径
        registry.addInterceptor(new URLInterceptor()).addPathPatterns("/**");
    }
}
