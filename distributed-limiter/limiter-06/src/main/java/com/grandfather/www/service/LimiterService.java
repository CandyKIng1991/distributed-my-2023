package com.grandfather.www.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.grandfather.www.common.ResultResponse;
import org.springframework.stereotype.Service;

/**
 * @author MrLiu
 */
@Service
public class LimiterService {

    /**
     * 埋点的测试方法
     *
     * @return 测试结果
     */
    @SentinelResource(value = "LimiterService.process")
    public ResultResponse process() {

        ResultResponse success = ResultResponse.success();
        return success;
    }
}
