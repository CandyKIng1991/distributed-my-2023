package com.grandfather.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @author MrLiu
 */
@SpringBootApplication
public class App {

    /**
     * Sentinel使用
     * 在控制界面上给方法加上限制(临时的).限制一秒,反复刷新就会看到限制结果
     *
     * @param args 字符串
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
