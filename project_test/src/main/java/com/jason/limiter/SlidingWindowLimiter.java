package com.jason.limiter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王政
 * @date 2022/7/28 14:20
 * 滑动窗口
 */
public class SlidingWindowLimiter {

    private final int limit = 10; // 时间窗口内最大请求数
    private final long interval = 1000; // 时间窗口 1000 ms, 1s
    private List<Long> reqTimes = new ArrayList<Long>() {
        {
            add(getNowTime());
        }
    };

    public boolean grant() {
        long t_m = getNowTime();
        // 判断t_m是否在时间窗口内
        if (t_m < reqTimes.get(0) + interval) {
            // 判断当前时间窗口内是否超过最大请求控制数
            if (reqTimes.size() < limit) {
                reqTimes.add(t_m);
                return true;
            } else {
                return false;
            }
        } else {
            // 如果不在时间窗口内，丢弃第一个时间点
            reqTimes.remove(0);
            return true;
        }
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }

}
