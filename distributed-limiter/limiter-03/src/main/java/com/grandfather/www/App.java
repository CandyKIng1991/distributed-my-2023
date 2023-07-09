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
     * <p>
     * 在控制界面中限流中将QPS限制为1秒,反复刷新界面,就会看到限流的json返回了
     *
     * @param args 字符串
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
