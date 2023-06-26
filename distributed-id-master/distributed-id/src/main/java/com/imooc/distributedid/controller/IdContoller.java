package com.imooc.distributedid.controller;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdContoller {

    @Autowired
    private SegmentService segmentService;

    @Autowired
    private SnowflakeService snowflakeService;

    @GetMapping("/segment")
    public Long segment() {
        return segmentService.getId("leaf-segment-test").getId();
    }

    @GetMapping("/segment2")
    public Result segment2() {

        Result result = new Result();
        result.setId(segmentService.getId("leaf-segment-test").getId());
        result.setStatus(Status.SUCCESS);
        result.setDescription("号段算法");
        return result;
    }

    @GetMapping("/snowflake")
    public Result snowflake() {



        return snowflakeService.getId("imooc").setDescription(snowflakeService.getId("imooc").getId(),"雪花算法");
    }
}
