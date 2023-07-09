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
     * 需要启动zookeeper
     * 这个配置是永久生效版本,不会因为服务关闭就被刷新了.
     *
     * @param args 字符串
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
