package com.distributed.www.distributedsharding01;/**
 * @author: MrLiu
 * @createTime: 2023/07/04 9:23
 * @description: xxx
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * <a href="http://localhost:8084/findAll">...</a>
     *
     * @return 查到结果
     */
    @GetMapping("/findAll")
    public List<OrderEntity> findAll() {

        return orderService.findAll();
    }


}
