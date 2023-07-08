package com.imooc.config;

import com.imooc.quart.MyQuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置类
 * @author MrLiu
 */
@Configuration
public class MyQuartJobConfig {

    /**
     * 实例化job
     *
     * @return 实例后
     */
    @Bean
    public JobDetail jobDetail() {
        JobDetail detail = JobBuilder.newJob(MyQuartzJob.class)

                // 定义名字和身份
                .withIdentity("job1", "group1")
                // 设置持久化
                .storeDurably()
                .build();
        return detail;
    }

    /**
     * 创建触发器,触发实例JobDetail,只会打印一次
     *
     * @return 创建结果
     */
    @Bean
    public Trigger trigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger1", "group1")
                // 启动时间
                .startNow()
                .build();
        return trigger;
    }
}
