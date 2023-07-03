package com.grandfather.www.blockhandeler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.gson.Gson;
import com.grandfather.www.common.Result;
import com.grandfather.www.common.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author MrLiu
 */ //如何返回json, springboot全局异常处理,太麻烦了,不如模仿源码直接PrintWriter打印回界面,因为项目小,如果大可以加上springboot全局处理
@Slf4j
@Component
public class LimiterBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.info("被限流了...");

        // 否则中文字符会乱码
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        // 设置utf-8要在它的上边,否则无效
        PrintWriter out = httpServletResponse.getWriter();

        // 简单的实现,返回json
        Result result = new Result();
        result.setId(500);
        result.setStatus(Status.EXCEPTION);
        result.setDescription("被限流了...");

        String json = new Gson().toJson(result);

        out.print("被限流了...");
        out.print("\n");
        out.print(json);
        out.flush();
        out.close();
    }
}
