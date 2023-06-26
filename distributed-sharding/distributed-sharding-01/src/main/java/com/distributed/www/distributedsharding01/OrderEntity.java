package com.distributed.www.distributedsharding01;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_order")
public class OrderEntity {

    @Id
    private Long orderId;

    private Integer userId;
}
