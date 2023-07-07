package com.grandfather.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 * @author MrLiu
 */
@SpringBootApplication
@EnableFeignClients(basePackages ={"com.grandfather.www.client"})
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }



}
