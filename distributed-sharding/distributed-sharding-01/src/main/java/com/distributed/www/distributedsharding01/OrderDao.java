package com.distributed.www.distributedsharding01;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByOrderId(Long orderId);

    List<OrderEntity> findByUserId(Integer userId);

}
