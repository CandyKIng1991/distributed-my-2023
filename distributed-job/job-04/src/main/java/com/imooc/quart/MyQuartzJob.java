package com.imooc.quart;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class MyQuartzJob extends QuartzJobBean {


    /**
     * 具体执行的内容
     *
     * @param context 配置文件
     * @throws JobExecutionException 产生的异常
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("MyQuartzJob...");
    }
}
