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
     * 访问地址测试:<a href="http://localhost:8083/swagger-ui.html">...</a>
     *
     * @param args 字符
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
