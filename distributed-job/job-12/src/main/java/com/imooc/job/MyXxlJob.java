package com.imooc.job;

import com.google.gson.Gson;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.core.util.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author MrLiu
 */
@Component
@Slf4j
public class MyXxlJob {

    @XxlJob("myXxlJobHandler")
    public ReturnT<String> execute(String param) {
        log.info("myXxlJobHandler execute...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        XxlJobLogger.log("myXxlJobHandler execute...");
        return ReturnT.SUCCESS;
    }


    @XxlJob("myXxlJobShardingVo")
    public ReturnT<String> shardingVo(String param) {
        log.info("myXxlJobHandler execute.......START");

        //轮询 流量均摊，推荐
        //故障转移 流量到第一台，查日志方便

        //从数据库里查询所有用户，为每一个用户生成结单
        //10w用户，2台服务器，每台运算5w用户数据，耗时减半
        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();

        //分片，必须掌握
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (Integer i : list) {
            if (i % shardingVo.getTotal() == shardingVo.getIndex()) {
                log.info("myXxlJobHandler execute...user={}. shardingVo={}",
                        i, new Gson().toJson(shardingVo));
            }
        }

        XxlJobLogger.log("myXxlJobHandler execute... END");
        return ReturnT.SUCCESS;
    }
}
