package com.jason.limiter;

/**
 * @author 王政
 * @date 2022/7/29 11:28
 * 令牌桶
 */
public class TokenBucket {

    private long timeStamp = getNowTime();
    private int capacity = 100; // 桶的容量 100
    private float rate = 0.1f; // 令牌放入速度
    private int tokens = 100; // 当前令牌数量

    public boolean grant() {
        long now = getNowTime();
        tokens = (int) Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;
        if (tokens < 1) {
            // 若取不到令牌，则拒绝
            return false;
        } else {
            // 还有令牌，领取令牌
            tokens -= 1;
            return true;
        }
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }

}
