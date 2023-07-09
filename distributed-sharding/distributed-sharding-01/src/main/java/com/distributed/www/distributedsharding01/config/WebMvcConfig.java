package com.distributed.www.distributedsharding01.config;/**
 * @author: MrLiu
 * @createTime: 2023/07/02 10:53
 * @description: xxx
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.config
 * @className: WebMvcConfig
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-02 10:53
 * @version: 1.0
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
