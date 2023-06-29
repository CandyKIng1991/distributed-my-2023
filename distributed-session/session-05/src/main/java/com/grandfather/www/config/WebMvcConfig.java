package com.grandfather.www.config;

import com.grandfather.www.util.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 需要添加这里统一token才会生效
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter loginIntercepter;

    /**
     * 添加拦截器
     *
     * @param registry 注册自定义的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 可以添加多个拦截
        registry.addInterceptor(loginIntercepter)
                // 配置拦截路径
                .addPathPatterns("/user/address")  //  /user/** 拦截所有的user路径
                .addPathPatterns("/user/infoWithJwt");

        // 登录拦截
        registry.addInterceptor(loginIntercepter)
                .addPathPatterns("/user/**")   //未登录的都会被拦截
                .excludePathPatterns("/user/login"); // 这个要排除在外，不然永远无法使用任何接口

        // 也可以做日志拦截
    }
}
