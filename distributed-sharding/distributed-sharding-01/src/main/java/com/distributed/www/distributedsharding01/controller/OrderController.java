package com.distributed.www.distributedsharding01.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/04 9:23
 * @description: xxx
 */

import com.distributed.www.distributedsharding01.bean.OrderEntity;
import com.distributed.www.distributedsharding01.common.Result;
import com.distributed.www.distributedsharding01.common.Status;
import com.distributed.www.distributedsharding01.service.OrderService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: distributed-my-2023
 * @package: com.distributed.www.distributedsharding01
 * @className: OrderController
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-04 9:23
 * @version: 1.0
 */

@RestController
@Api(value = "订单管理", tags = "订单管理")
public class OrderController {


    @Autowired
    private OrderService orderService;

    Result result = new Result();

    AtomicInteger count = new AtomicInteger();

    /**
     * <a href="http://localhost:8084/findAll">...</a>
     *
     * @return 查到结果
     */
    @GetMapping("/findAll")
    @ApiOperation("查找全部订单")
    public Result findAll() {

        List<OrderEntity> orderEntityList = orderService.findAll();

        result.setId(orderEntityList.size());
        result.setStatus(Status.SUCCESS);
        result.setDescription(new Gson().toJson(orderEntityList));
        return result;
    }

    /**
     * 保存订单
     *
     * @return 是否成功
     */
    @GetMapping("/save")
    @ApiOperation("保存订单")
    public Result save() {
        boolean save = orderService.save();

        if (save) {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.SUCCESS);
            result.setDescription("添加成功");
        } else {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.EXCEPTION);
            result.setDescription("添加失败");
        }

        return result;
    }

}
