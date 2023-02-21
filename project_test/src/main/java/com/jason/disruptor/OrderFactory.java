package com.jason.disruptor;

import com.lmax.disruptor.EventFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王政
 * @date 2022/11/8 14:48
 */
public class OrderFactory implements EventFactory<Order> {

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Order newInstance() {
        counter.getAndIncrement();
        System.out.println("OrderFactory.newInstance:" + counter);
        return new Order();
    }

}
