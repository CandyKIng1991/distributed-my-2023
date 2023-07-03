package com.grandfather.www.controller;

import com.grandfather.www.exception.BizException;
import com.grandfather.www.service.LimiterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 埋点的方法
     */
    @Autowired
    private LimiterService limiterService;


    /**
     * 改为测试埋点
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

        // 全局处理这种情况产生的异常
        try {
            limiterService.process();
        } catch (Exception exception) {
            throw new BizException("500", "方法被限流了.");
        }

        return "sentinel - " + result.getAndIncrement();
    }

}
