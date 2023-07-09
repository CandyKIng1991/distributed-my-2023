package com.grandfather.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author MrLiu
 */
@SpringBootApplication
public class App {

    /**
     * Sentinel使用
     * 启动看日志和访问: localhost:8080/
     * 需要启动第三方的sentinel-dashboard.jar
     *
     * @param args 字符串
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
