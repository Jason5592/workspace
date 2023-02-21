package com.jason.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author 王政
 * @date 2022/11/8 14:46
 */
public class OrderHandler implements EventHandler<Order> {

    @Override
    public void onEvent(Order order, long l, boolean b) {
        System.out.println(Thread.currentThread().getName() + " 消费者处理中:" + l);
        order.setInfo("info" + order.getId());
        order.setPrice(Math.random());
    }

}
