package com.grandfather.www;/**
 * @author: MrLiu
 * @createTime: 2023/07/04 9:21
 * @description: xxx
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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


    public boolean deletedTheSame() {

        List<OrderEntity> orderEntityList = new ArrayList<>();

        List<OrderEntity> all = orderDao.findAll();

        if (!all.isEmpty()) {
            for (OrderEntity orderEntity : all) {

                for (OrderEntity entity : orderEntityList) {

                    if (!entity.getOrderId().equals(orderEntity.getOrderId())) {

                        orderEntityList.add(orderEntity);
                    }
                }
            }

        }


        for (OrderEntity orderEntity : all) {

            for (OrderEntity entity : orderEntityList) {

                if (entity.getOrderId().equals(orderEntity.getOrderId())) {
                    orderDao.delete(orderEntity);
                    System.out.println("删除 :" + orderEntity.getOrderId());
                }
            }
        }


        return true;
    }


    public boolean deletedById(Long orderId) {


        OrderEntity byOrderId = orderDao.findByOrderId(orderId);

        if (byOrderId != null) {
            Integer b = orderDao.deleteByOrderId(orderId);

            System.out.println("b: " + b);

            return true;
        } else {
            orderDao.deleteByOrderId(orderId);

            System.out.println("不存在无法删除");
            return false;
        }
    }
}
