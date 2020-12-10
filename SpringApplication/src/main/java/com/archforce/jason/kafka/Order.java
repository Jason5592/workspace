package com.archforce.jason.kafka;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 订单ID
     */
    private long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单价格 单位分
     */
    private int orderAmount;

    public Order(long orderId, String orderNo, int orderAmount) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.orderAmount = orderAmount;
    }
}
