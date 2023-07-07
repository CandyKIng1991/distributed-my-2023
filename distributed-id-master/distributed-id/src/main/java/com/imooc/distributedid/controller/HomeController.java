package com.imooc.distributedid.controller;

import com.imooc.distributedid.uitil.PortServer;
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

        String url = PortServer.getUrl();
        stringBuilder.append("<a href='" + url + "/segment' target='_blank' >号段算法</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='" + url + "/segment2' target='_blank' >号段封装</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='" + url + "/snowflake' target='_blank' >雪花算法</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='" + url + "/api/segment/get/leaf-segment-test' target='_blank' >号段算法(自带)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='" + url + "/api/snowflake/get/test' target='_blank' >雪花算法(自带)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='" + url + "/cache' target='_blank' >缓存(自带)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();
    }

}
