package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }


    /**
     * 处理任务调度,多线程的情况
     *
     * @return 任务线程
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

        // 创建十个线程
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
}
