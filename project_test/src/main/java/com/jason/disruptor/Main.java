package com.jason.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

/**
 * @author 王政
 * @date 2022/11/8 14:47
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 创建订单工厂
        OrderFactory orderFactory = new OrderFactory();
        // RingBuffer的大小
        int RING_BUFFER_SIZE = 1024;
        // 创建Disruptor
        Disruptor<Order> orderDisruptor = new Disruptor<>(orderFactory, RING_BUFFER_SIZE, Executors.defaultThreadFactory());
        // 设置事件处理器，即消费者
        orderDisruptor.handleEventsWith(new OrderHandler(), new OrderHandler1()).then(new OrderHandler2());
        orderDisruptor.start();

        RingBuffer<Order> orderRingBuffer = orderDisruptor.getRingBuffer();

        // 生产数据
        for (int i = 0; i < 1025; i++) {
            long sequence = orderRingBuffer.next();
            Order order = orderRingBuffer.get(sequence);
            order.setId(i);

            orderRingBuffer.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }

        Thread.sleep(10000);

        orderDisruptor.shutdown();
    }

}
