package com.distributed.www.distributedsharding01.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/02 10:02
 * @description: xxx
 */


import com.distributed.www.distributedsharding01.uitil.PortServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

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

    AtomicInteger result = new AtomicInteger(1);

    /**
     * 防止404界面
     *
     * @return 一个提示
     */
    @GetMapping("/")
    @ApiOperation("主页")
    public String index() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/swagger-ui.html' target='_blank' >所有接口的swagger</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/findAll' target='_blank' >获取所有订单</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/guavaOver' target='_blank' >模拟有个申请超过桶的最大容量(点开后多次F5,看后台日志)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<a href='").append(PortServer.getUrl()).append("/guavaSnatch' target='_blank' >抢夺资源(需要ab压测工具测试)</a>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<br/>");
        stringBuilder.append("<h1>欢迎爸爸,登录成功</h1>");

        return stringBuilder.toString();

    }

}
