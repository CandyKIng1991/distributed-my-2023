package com.grandfather.www.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MrLiu
 */
@RestController
@Slf4j
@Api(value = "分布式限流测试", tags = {"分布式限流测试"})
public class LimiterController {

    AtomicInteger result = new AtomicInteger(1);


    /**
     * 第一个测试,sentinel
     *
     * <p>
     * <p>
     * <p>
     * 抢夺资源
     *
     * </p>
     */
    @ApiOperation("sentinel测试打印日志 http://localhost:8083/sentinel/")
    @GetMapping("/sentinel")
    public String sentinel() {

        return "sentinel - " + result.getAndIncrement();
    }

}
