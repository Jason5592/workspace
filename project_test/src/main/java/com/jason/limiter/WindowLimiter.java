package com.jason.limiter;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王政
 * @date 2022/7/28 10:22
 * 固定窗口
 */
public class WindowLimiter {

    private long timeStamp = getNowTime();
    private AtomicInteger reqCount = new AtomicInteger(0);
    private final int limit = 10; // 时间窗口内最大请求数
    private final long interval = 1000; // 时间窗口 1000 ms, 1s

    public boolean grant() {
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            reqCount.getAndIncrement();
            return reqCount.get() <= limit;
        } else {
            timeStamp = now;
            reqCount.set(1);
            return true;
        }
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }

}
