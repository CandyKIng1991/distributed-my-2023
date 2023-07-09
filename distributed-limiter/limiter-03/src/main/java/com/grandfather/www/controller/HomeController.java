package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/02 10:02
 * @description: xxx
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: distributed-my-2023
 * @package: com.grandfather.www.controller
 * @className: HomeController
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-02 10:02
 * @version: 1.0
 */

@RestController
@Slf4j
@Api(value = "主页接口", tags = {"主页接口"})
public class HomeController {


    /**
     * 防止404界面
     *
     * @return 一个提示
     */
    @GetMapping("/index")
    @ApiOperation("主页")
    public String index() {

        return "恭喜你刷到了主页面";

    }

}
