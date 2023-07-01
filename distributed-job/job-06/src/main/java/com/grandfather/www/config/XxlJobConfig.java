package com.grandfather.www.config;/**
 * @author: MrLiu
 * @createTime: 2023/07/01 16:56
 * @description: xxx
 */

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @projectName:    distributed-my-2023
 * @package:        com.grandfather.www.config
 * @className:      XxlJobConfig
 * @author:     your-father
 * @description:  TODO
 * @date:    2023-07-01 16:56
 * @version:    1.0
 */
@Component
@Slf4j
public class XxlJobConfig {

    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    @Value("${xxl.job.accessToken}")
    private String accessToken;

     // 不配置就会自动配置
    //@Value("${xxl.job.executor.port}")
    //private int port;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setLogPath(logPath);

        xxlJobSpringExecutor.setAccessToken(accessToken);
        //xxlJobSpringExecutor.setPort(port);
        return xxlJobSpringExecutor;
    }
}

