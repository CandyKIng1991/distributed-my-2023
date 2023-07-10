package com.grandfather.www.dao;

import com.grandfather.www.bean.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderDao extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByOrderId(Long orderId);

    List<OrderEntity> findByUserId(Integer userId);

    @Modifying
    @Transactional
    Integer deleteByOrderId(Long orderId);
}
