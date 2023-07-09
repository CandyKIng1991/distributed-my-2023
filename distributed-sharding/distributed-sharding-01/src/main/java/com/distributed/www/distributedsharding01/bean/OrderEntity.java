package com.distributed.www.distributedsharding01.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MrLiu
 */
@Data
@Entity
@Table(name = "t_order")
@ApiModel("订单实体")
public class OrderEntity {

    @Id
    @ApiModelProperty("订单 id")
    private Long orderId;

    @ApiModelProperty("用户 id")
    private Integer userId;
}
