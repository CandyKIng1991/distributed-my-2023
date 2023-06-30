package com.imooc.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 多线程执行任务调度
 */
@Slf4j
@Component
public class MySchedule {


    /**
     * 模拟两个执行的线程
     */
    @Scheduled(fixedRate = 3000)
    public void process1() {
        log.info("process1...start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("process1...stop");
    }

    @Scheduled(fixedRate = 3000)
    public void process2() {
        log.info("process2...start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("process2...stop");
    }


}
