package com.grandfather.www.controller;


import com.grandfather.www.util.PortServer;
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

        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/login?username=admin&password=admin' target='_blank' >用户登录(生成token接口)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/loginWithJwt?username=admin&password=admin' target='_blank' >用户登录(需要上一步的token)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/infoWithJwt' target='_blank' >用户信息(需要上一步的token)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/user/address' target='_blank' >用上个接口的tokenId(需要上一步的token)</a> ");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();
    }

}
