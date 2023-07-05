package com.grandfather.www.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrLiu
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<a href='http://localhost:8081/user/login' target='_blank' >用户登录</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("(上个连接格式)格式: ");
        stringBuilder.append("<br/>");
        stringBuilder.append("http://localhost:8081/user/login?username=你的名字&password=你的密码");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='http://localhost:8081/user/info'  target='_blank'>用户信息</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();
    }

}
