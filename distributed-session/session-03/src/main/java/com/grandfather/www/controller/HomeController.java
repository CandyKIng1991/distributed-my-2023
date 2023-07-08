package com.grandfather.www.controller;


import com.grandfather.www.uitil.PortServer;
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

        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/loginWithToken?username=admin&password=admin' target='_blank' >用户登录</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/infoWithToken' target='_blank' >用户信息(上个接口得到的结果防止postman中测试)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("(上个连接格式)格式: ");
        stringBuilder.append("<br/>");
        stringBuilder.append(PortServer.getUrl()).append("/user/infoWithToken");
        stringBuilder.append("token=token_084a37ce-8e8f-48a7-8c30-1eb43c213f0e(第一个接口获得)");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();
    }

}
