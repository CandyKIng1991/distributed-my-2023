package com.grandfather.www.controller;

import com.grandfather.www.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 调用库存
     *
     * <a href="http://localhost:8085/create?count=5"/>
     *
     * @param count 扣除数量
     * @return 结果
     */
    @GetMapping("/create")
    public Boolean create(@RequestParam Integer count) {
        return orderService.create(count);
    }
}
