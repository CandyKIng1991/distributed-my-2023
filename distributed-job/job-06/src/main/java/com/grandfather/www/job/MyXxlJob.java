package com.grandfather.www.job;

import com.google.gson.Gson;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class MyXxlJob {

    @XxlJob("myXxlJobHandler")
    public ReturnT<String> execute(String param) {
        log.info("myXxlJobHandler execute...");
        XxlJobLogger.log("myXxlJobHandler execute...");
        return ReturnT.SUCCESS;
    }
}
