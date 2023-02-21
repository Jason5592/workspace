package com.jason.disruptor;

import lombok.Data;

/**
 * @author 王政
 * @date 2022/11/8 14:44
 */
@Data
public class Order {

    // 订单ID
    private long id;

    // 订单信息
    private String info;

    // 订单价格
    private double price;

}
