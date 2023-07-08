package com.imooc.controller;


import com.imooc.uitil.PortServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/login?username=admin&password=123456' target='_blank' >用户登录</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("(上个连接格式)格式: ");
        stringBuilder.append("<br/>");
        stringBuilder.append(PortServer.getUrl()).append("/user/login?username=你的名字&password=你的密码");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/info'  target='_blank'>用户信息</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();
    }

}
