package com.kotei.magicconch.clubspongebob.config;

import com.kotei.magicconch.clubspongebob.interceptor.AdminLoginInterceptor;
import com.kotei.magicconch.clubspongebob.interceptor.LoginInterceptor;
import com.kotei.magicconch.clubspongebob.interceptor.NotifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private NotifyInterceptor notifyInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[]addPathPatterns={"/**"};
        //不需要拦截的路径
        String [] excludePathPatterns={
                "/",
                "/login",
                "/register",
                "/admin/**",
                "/assets/**"
        };
        //注册一个登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
        String[]addPathPatterns2={"/**"};
        //不需要拦截的路径
        String [] excludePathPatterns2={
                "/login",
                "/register",
                "/admin/**",
                "/assets/**"
        };
        registry.addInterceptor(notifyInterceptor)
                .addPathPatterns(addPathPatterns2)
                .excludePathPatterns(excludePathPatterns2);

        //注册一个登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
        String[]addPathPatterns3={"/admin/**"};
        //不需要拦截的路径
        String [] excludePathPatterns3={
                "/admin/login"
        };
        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns(addPathPatterns3)
                .excludePathPatterns(excludePathPatterns3);
    }
}
