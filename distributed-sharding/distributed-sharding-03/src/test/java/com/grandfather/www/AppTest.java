package com.grandfather.www;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AppTest
{
    @Autowired
    private OrderDao orderDao;

    /**
     * 单库分表使用的插入数据
     */
    @Test
    public void insert() {

       for(int i = 0; i < 20; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUserId(new Random().nextInt(999));
            orderDao.save(orderEntity);
        }
    }

    /**
     * 查询数据 878380347254353920  会查两个库
     *
     * 单库只会查一次
     *
    */
    @Test
    public void findByOrderId() {
        OrderEntity byOrderId = orderDao.findByOrderId(878391116247314432L);
        log.info("byOrderId={}", byOrderId);

        System.out.println("order :{"+byOrderId+"}");
    }

    /**
     * 通过用户ID查询  ---------- 只是分表不分库
     * 从一个数据源查两个表,这里还是查两次
     */
    @Test
    public void findByUserId() {
        List<OrderEntity> byUserId = orderDao.findByUserId(638);
        log.info("byUserId={}", byUserId);
    }

    /**
     * 软删除,就是修改,这里只能修改userId
     * 修改的字段不能是sharding-column配置的字段
     */
    @Test
    public void update() {
        OrderEntity byOrderId = orderDao.findByOrderId(878391116297646081L);
        log.info("修改前: byOrderId={}", byOrderId);
        byOrderId.setUserId(10099);
        orderDao.save(byOrderId);
        log.info("修改后: byOrderId={}", byOrderId);
    }
}
