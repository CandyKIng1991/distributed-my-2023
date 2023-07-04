package com.distributed.www.distributedsharding01;/**
 * @author: MrLiu
 * @createTime: 2023/07/04 9:21
 * @description: xxx
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: distributed-my-2023
 * @package: com.distributed.www.distributedsharding01
 * @className: OrderService
 * @author: your-father
 * @description: TODO
 * @date: 2023-07-04 9:21
 * @version: 1.0
 */
@Component
public class OrderService {


    @Autowired
    private OrderDao orderDao;


    public List<OrderEntity> findAll() {

        List<OrderEntity> all = orderDao.findAll();

        if (!all.isEmpty()) {
            for (OrderEntity orderEntity : all) {
                System.out.println(new Gson().toJson(orderEntity));
            }

            return all;
        } else {


            return null;
        }


    }

}
