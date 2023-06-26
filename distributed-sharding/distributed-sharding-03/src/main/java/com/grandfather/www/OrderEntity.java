package com.grandfather.www;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_order")
public class OrderEntity {

    @Id
    // 配置ID是唯一的,因为properties配置了雪花算法,所以这里使用这个注解,就会自动生成唯一的ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer userId;

    @Override
    public String toString() {
        return "\n"+"  OrderEntity : { \n" +
                "   orderId :" + orderId +
                ";\n   userId :" + userId +"; \n"+
                '}'+"\n";
    }
}
