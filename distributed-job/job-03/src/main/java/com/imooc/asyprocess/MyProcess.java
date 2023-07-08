package com.imooc.asyprocess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * 异步处理线程方式
 * @author MrLiu
 */
@Slf4j
@Component
public class MyProcess {

    /**
     * 各自执行各自的,互不干扰的异步处理方式
     * <p>
     * <p>
     * 慎用，推荐MQ,分布式中间件异步处理,代替这种方式
     */
    @Async
    public void doProcess1() {
        log.info("doProcess1...start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("doProcess1...stop");
    }
}
