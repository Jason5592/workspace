package com.jason.limiter;

/**
 * @author 王政
 * @date 2022/7/28 18:26
 * 漏桶
 */
public class LeakyBucket {

    private long timeStamp = getNowTime();
    private int capacity = 100; // 桶的容量 100
    private float rate = 0.1f; // 水漏出的速度 0.1（浮点型 * 整数结果去除精度）
    private int water = 0; // 当前水量(当前累积请求数) 0

    public boolean grant() {
        long now = getNowTime();
        water = (int) Math.max(0, water - (now - timeStamp) * rate);
        timeStamp = now;
        if ((water + 1) < capacity) {
            // 尝试加水，并且水还未满
            water += 1;
            return true;
        } else {
            // 水满，拒绝加水
            return false;
        }
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }

}
