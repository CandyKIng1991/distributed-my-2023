package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/02 10:02
 * @description: xxx
 */

import com.google.common.util.concurrent.RateLimiter;
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
    @GetMapping("/index")
    @ApiOperation("主页")
    public String index() {

        return "恭喜你刷到了主页面";

    }

    /**
     * 第一个测试:
     *
     * <p>
     * <p>
     * 模拟用户获取令牌
     */
    @GetMapping("/guava")
    @ApiOperation("拟用户获取令牌")
    public String guava() {
        //创建可放2令牌的桶且每秒放2令牌，0.5秒放1令牌
        RateLimiter rateLimiter = RateLimiter.create(2);

        log.info("{}", rateLimiter.acquire());
        log.info("{}", rateLimiter.acquire());
        log.info("{}", rateLimiter.acquire());
        log.info("{}", rateLimiter.acquire());

        return "拟用户获取令牌";
    }


    /**
     * 第二个测试:
     *
     * <p>
     * <p>
     * 模拟有个申请超过桶的最大容量
     */
    @GetMapping("/guavaOver")
    @ApiOperation("模拟有个申请超过桶的最大容量")
    public String guavaOver() {
        //创建可放2令牌的桶且每秒放2令牌，0.5秒放1令牌
        RateLimiter rateLimiter = RateLimiter.create(2);

        //平滑输出，允许突发流量
        log.info("{}", rateLimiter.acquire(3));
        log.info("{}", rateLimiter.acquire());
        log.info("{}", rateLimiter.acquire());
        log.info("{}", rateLimiter.acquire());

        return "申请超过桶的最大容量";
    }


    /**
     * 第三个测试:
     *
     * <p>
     * <p>
     * 使用ab命令进行压测
     */
    @GetMapping("/guavaJmeter")
    @ApiOperation("ab压测:ab -n 100 -c 10 http://localhost:8083/guavaJmeter/")
    public void guavaJmeter() {
        log.info("访问 : " + "{" + result.getAndIncrement() + "}" + " 次");
    }

}
