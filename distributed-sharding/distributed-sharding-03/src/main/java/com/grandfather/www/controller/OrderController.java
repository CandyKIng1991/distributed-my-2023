package com.grandfather.www.controller;/**
 * @author: MrLiu
 * @createTime: 2023/07/04 9:23
 * @description: xxx
 */

import com.google.gson.Gson;
import com.grandfather.www.bean.OrderEntity;
import com.grandfather.www.common.Result;
import com.grandfather.www.common.Status;
import com.grandfather.www.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/findByOrderId/{orderId}")
    @ApiOperation("查找订单")
    public Result findByOrderId(@PathVariable Long orderId) {

        if (orderId != null) {
            OrderEntity byOrderId = orderService.findByOrderId(orderId);

            result.setId(count.getAndIncrement());
            result.setStatus(Status.SUCCESS);
            result.setDescription(new Gson().toJson(byOrderId));

        } else {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.EXCEPTION);
            result.setDescription("查找失败");
        }

        return result;
    }

    @GetMapping("/findByUserId/{userId}")
    @ApiOperation("查找订单列表")
    public Result findByUserId(@PathVariable Integer userId) {

        if (userId != null) {
            List<OrderEntity> orderEntityList = orderService.findByUserId(userId);

            result.setId(count.getAndIncrement());
            result.setStatus(Status.SUCCESS);
            result.setDescription(new Gson().toJson(orderEntityList));

        } else {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.EXCEPTION);
            result.setDescription("查找失败");
        }

        return result;
    }

    @GetMapping("/update/{orderId}")
    @ApiOperation("修改成功")
    public Result update(@PathVariable Long orderId) {

        boolean updated = orderService.update(orderId);

        if (updated) {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.SUCCESS);
            result.setDescription("修改成功");
        } else {
            result.setId(count.getAndIncrement());
            result.setStatus(Status.EXCEPTION);
            result.setDescription("修改失败");
        }

        return result;


    }


    @GetMapping("/deletedTheSame")
    public boolean deletedTheSame() {

        return orderService.deletedTheSame();
    }

    /**
     * 通过orderId 删除订单
     *
     * @param id 订单id
     * @return 删除结果
     */
    @GetMapping("/deletedById/{id}")
    public boolean deletedById(@PathVariable Long id) {

        return orderService.deletedById(id);
    }
}
