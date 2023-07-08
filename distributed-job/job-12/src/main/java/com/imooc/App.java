package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuyangos8888
 *
 * <p>
 * XXL-JOB的项目初始搭建
 *
 * </p>
 */
@SpringBootApplication
public class App {

    /**
     * 先启动xxl-job-master,再启动这个
     *
     * @param args 字符串
     */
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }
}
