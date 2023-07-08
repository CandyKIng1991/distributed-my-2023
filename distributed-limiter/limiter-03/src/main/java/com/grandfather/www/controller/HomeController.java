package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/02 10:02
 * @description: xxx
 */

import com.grandfather.www.uitil.PortServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.controller
 * @className: HomeController
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-02 10:02
 * @version: 1.0
 */

@RestController
@Slf4j
@Api(value = "主页接口", tags = {"主页接口"})
public class HomeController {


    /**
     * 防止404界面
     *
     * @return 一个提示
     */
    @GetMapping("/index")
    @ApiOperation("主页")
    public String index() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("swagger-ui.html' target='_blank' >所有接口的swagger</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/sentinel' target='_blank' >工具测试(点开后,看后台日志)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();

    }

}
