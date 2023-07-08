package com.imooc.schedule;


import com.imooc.asyprocess.MyProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 多线程执行任务调度
 * @author MrLiu
 */
@Slf4j
@Component
public class MySchedule {

    @Autowired
    private MyProcess process;


    /**
     * 每三秒执行一次业务,不管上个任务是否执行结束
     */
    @Scheduled(fixedRate = 3000)
    public void process1() {
        log.info("process1...start");
        process.doProcess1();

        log.info("process1...stop");
    }


}
