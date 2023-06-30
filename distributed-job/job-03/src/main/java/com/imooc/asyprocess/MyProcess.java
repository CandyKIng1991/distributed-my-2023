package com.imooc.asyprocess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * 异步处理线程方式
 */
@Slf4j
@Component
public class MyProcess {

    /**
     * 慎用，推荐MQ
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
