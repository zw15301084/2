package com.example.demo.configuration;

import com.example.demo.interceptors.URLInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        // 娣诲姞涓�涓嫤鎴櫒锛屾嫤鎴互/涓哄墠缂�鐨� url璺緞
        registry.addInterceptor(new URLInterceptor()).addPathPatterns("/**");
    }
}
