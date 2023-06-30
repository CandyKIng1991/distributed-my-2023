package com.imooc.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@EnableScheduling
public class MySchedule {

    AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * fixedDelay = 3000 每三秒打印一次方法内的日志内容
     *
     * <p>
     *
     * @EnableScheduling 是否开启 schedule ,加在类上,作用就是当前类
     * 加在@SpringBootApplication 上,就是整个项目生效
     *
     * <p>
     *
     *
     *
     * <p>
     * fixedDelay 默认是int型
     * fixedDelayString 说明等号后要是字符型数据
     * 默认项目启动就打印 initialDelay 不在启动的时候打印 -----延迟启动
     * initialDelay 延迟启动
     * fixedDelay 固定延迟，时间间隔是前次任务的结束到下次任务的开始
     * fixedRate 时间间隔是前次任务和下次任务的开始
     * <p>
     * 这里是单线程,所以只能等任务完全执行完,才能执行下一个任务
     * </p>
     */
    @Scheduled(fixedDelay = 3000, initialDelay = 5000)
    public void process() {

        log.info("********* 初级测试Schedule " + atomicInteger.incrementAndGet() + "***********");

    }


    /**
     * crontab  https://cron.qqe2.com/ 这个网址可以解析表达式,输入条件自动生成表达式
     *
     * <p>
     * 表达式的使用
     */
    @Scheduled(cron = "0,5 * * * * ?")
    public void process2() {


        log.info("process....start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("process....stop");
    }

}
