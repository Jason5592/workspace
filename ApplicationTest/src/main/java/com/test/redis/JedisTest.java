package com.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.Collections;
import java.util.List;

public class JedisTest {

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);

        jedisPool = new JedisPool(jedisPoolConfig, "192.168.162.128", 6379, 3000, "123456");

    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    @Test
    public void test1() {
        Jedis jedis = getJedis();
        System.out.println(jedis.set("age", "20"));
        System.out.println(jedis.get("age"));
        jedis.close();
    }

    @Test
    public void test2() {
        Jedis jedis = getJedis();
        // 管道执行不存在原子性，报错继续执行无法回滚
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("name", "jason");
        pipeline.hset("user", "id", "11");
        pipeline.hset("user", "weight", "70");
        pipeline.incr("age");
        List<Object> results = pipeline.syncAndReturnAll();
        System.out.println(results);
        jedis.close();
    }

    @Test
    public void test3() {
        // 可用lua脚本实现事务控制
        try (Jedis jedis = getJedis()) {
            String stockKey = "product_stock:10001";
            jedis.set(stockKey, "15");
            String script = "local count = redis.call('get', KEYS[1]) " +
                    "local a = tonumber(count) " +
                    "local b = tonumber(ARGV[1]) " +
                    "if a >= b then redis.call('set', KEYS[1], a - b) " +
                    // 模拟语法报错回滚操作
                    "c = 0 " +
                    "return 1 " +
                    "end " +
                    "return 0";
            Object obj = jedis.eval(script, Collections.singletonList(stockKey), Collections.singletonList("10"));
            System.out.println(obj);
        } catch (Exception e) {
            System.out.println("redis执行报错！" + e);
        }
    }
}
