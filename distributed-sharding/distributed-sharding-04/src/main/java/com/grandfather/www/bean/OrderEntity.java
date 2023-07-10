package com.grandfather.www.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author MrLiu
 */
@Data
@Entity
@Table(name = "t_order")
@ApiModel("订单实体")
public class OrderEntity {

    @Id
    // 配置ID是唯一的,因为properties配置了雪花算法,所以这里使用这个注解,就会自动生成唯一的ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("订单 id")
    private Long orderId;

    @ApiModelProperty("用户 id")
    private Integer userId;

    @Override
    public String toString() {
        return "\n" + "  OrderEntity : { \n" +
                "   orderId :" + orderId +
                ";\n   userId :" + userId + "; \n" +
                '}' + "\n";
    }
}
