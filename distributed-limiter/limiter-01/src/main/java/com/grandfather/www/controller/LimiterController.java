package com.grandfather.www.controller;

import com.google.common.util.concurrent.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrLiu
 */
@RestController
@Slf4j
@Api(value = "限流测试", tags = {"限流测试"})
public class LimiterController {

    /**
     * 创建在内存当中的
     */
    private RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * 第四个测试,模拟抢票机制
     * <p>
     * <p>
     * <p>
     * 抢夺资源
     *
     * </p>
     */
    @GetMapping("/guavaSnatch")
    @ApiOperation("ab压测:ab -n 100 -c 10 http://localhost:8083/guavaSnatch/")
    public void guavaSnatch() {

        boolean tryAcquire = rateLimiter.tryAcquire();

        if (tryAcquire) {
            //扣库存，下单....(数据库撑不住)
            log.info("恭喜你，抢到了！");
        } else {
            log.info("不好意思，你手慢了，没抢到");
        }

    }

}
