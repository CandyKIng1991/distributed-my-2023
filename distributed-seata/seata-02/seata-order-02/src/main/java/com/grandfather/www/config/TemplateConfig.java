package com.grandfather.www.config;/**
 * @author: MrLiu
 * @createTime: 2023/07/07 13:14
 * @description: xxx
 */

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.config
 * @className: TemplateConfig
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-07 13:14
 * @version: 1.0
 */
@Component
public class TemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
