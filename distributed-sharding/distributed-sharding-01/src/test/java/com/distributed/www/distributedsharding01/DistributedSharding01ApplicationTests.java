package com.distributed.www.distributedsharding01;

import com.distributed.www.distributedsharding01.bean.OrderEntity;
import com.distributed.www.distributedsharding01.dao.OrderDao;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DistributedSharding01ApplicationTests {

    @Autowired
    private OrderDao orderDao;

    /**
     * 首次测试使用的插入数据
     */
    @Test
    public void insert() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(System.currentTimeMillis());
        orderEntity.setUserId(new Random().nextInt(999));
        OrderEntity save = orderDao.save(orderEntity);

        if (save.getOrderId()!=null) {

        }
    }


    @Test
    public void findAll() {

        List<OrderEntity> all = orderDao.findAll();

        for (OrderEntity orderEntity : all) {
            System.out.println(new Gson().toJson(orderEntity));
        }

    }
}
