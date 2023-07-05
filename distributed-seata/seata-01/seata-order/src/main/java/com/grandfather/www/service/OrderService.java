package com.grandfather.www.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author MrLiu
 */
@Service
@Slf4j
public class OrderService {


    /**
     * 扣库存
     *
     * @param count 数量
     * @return 结果
     */
    public Boolean create(Integer count) {

        //调用product 扣库存
        String url = "http://localhost:8086/deduct?productId=5001&count=" + count;
        Boolean result = new RestTemplate().getForObject(url, Boolean.class);

        if (result != null && result) {
            //可能抛出异常
            if (5 == count) {
                throw new RuntimeException("order发生异常了");
                // 等于5的时候,后边的订单没有创建,但是,库存扣了,就是问题
            }

            log.info("数据库开始创建订单");
            return true;
        }

        return false;
    }
}
