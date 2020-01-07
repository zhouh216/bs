package com.fiction.crawler.web;

import com.fiction.crawler.web.intercept.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//web应用配置
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login**").excludePathPatterns("/static/**")
                .excludePathPatterns("/user/**").excludePathPatterns("/register**")
                .excludePathPatterns("/order/**")
                .excludePathPatterns("/fc/crawler**").excludePathPatterns("/crawler**");
    }
}