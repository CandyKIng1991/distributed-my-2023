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
     * 分库分表使用的插入数据
     */
    @Test
    public void insert() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(new Random().nextInt(999));
        orderDao.save(orderEntity);
    }

    /**
     * 查询数据 878380347254353920  会查两个库
     *
     * 上一个的日志中获取ID
     * ShardingSphere-SQL                       : Actual SQL: ds1 ::: insert into t_order_0 (user_id, order_id) values (?, ?) ::: [695, 878380347254353920]
     */
    @Test
    public void findByOrderId() {
      OrderEntity byOrderId = orderDao.findByOrderId(878380347254353920L);
        log.info("byOrderId={}", byOrderId);

        System.out.println("order :{"+byOrderId+"}");
    }

    /**
     * 通过用户ID查询
     * 从一个数据源查两个表
     * 分库分表数据很难查询(在navicat这样可视化工具中),因此要做个后台管理界面
     * 订单数据量不够大,不要分库分表
     */
    @Test
    public void findByUserId() {
        List<OrderEntity> byUserId = orderDao.findByUserId(695);
        log.info("byUserId={}", byUserId);
    }
}
