package com.test.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.concurrent.Executors;

public class CuratorTest {

    private static final CuratorFramework client;

    static {
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.162.128:2180,192.168.162.128:2181," +
                        "192.168.162.128:2182,192.168.162.128:2183," +
                        "192.168.162.128:2184,192.168.162.128:2185")
                .sessionTimeoutMs(50000)
                .connectionTimeoutMs(30000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        // 创建会话
        client.start();
    }

    @Test
    public void test1() throws Exception {
        // 创建一个初始内容为空的节点
        client.create().forPath("/China1");
        // 创建一个初始内容不为空的节点
        client.create().forPath("/America1", "node".getBytes());
        // 创建一个初始内容为空的临时节点
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/France1");
        // 递归创建，只有叶子节点才是临时节点
        client.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/Russia/car1", "node".getBytes());
    }

    @Test
    public void test2() throws Exception {
        // 异步创建节点
        // 如果指定了线程池，那么相应的操作就会在线程池中执行
        // 如果没有指定，那么就会使用zookeeper的EventThread线程对事件进行串行处理
        client.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("当前线程:" + Thread.currentThread().getName() + ",code:" + curatorEvent.getResultCode()
                        + ",type:" + curatorEvent.getType());
            }
        }, Executors.newFixedThreadPool(10)).forPath("/async-create-node1");

        client.create().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("当前线程:" + Thread.currentThread().getName() + ",code:" + curatorEvent.getResultCode()
                        + ",type:" + curatorEvent.getType());
            }
        }).forPath("/async-create-node2");
    }

    @Test
    public void test3() throws Exception {
        // 获取节点内容
        byte[] data = client.getData().forPath("/America");
        System.out.println(new String(data));
        byte[] data2 = client.getData().storingStatIn(new Stat()).forPath("/America"); //传入一个旧的stat变量,来存储服务端返回的最新的节点状态信息
        System.out.println(new String(data2));
    }

    @Test
    public void test4() throws Exception {
        // 更新数据
        Stat stat = client.setData().forPath("/America");
        client.setData().withVersion(stat.getVersion()).forPath("/America", "node".getBytes());
    }

    @Test
    public void test5() throws Exception {
        // 删除节点
        // 只能删除叶子节点
        client.delete().forPath("/China");
        // 删除一个，并递归删除其所有子节点
        client.delete().deletingChildrenIfNeeded().forPath("/Russia");
        // 指定版本删除节点
        client.delete().withVersion(5).forPath("/America");
        // 由于一些网络原因，上述的删除操作有可能失败，使用guaranteed()，如果删除失败，会记录下来，只要会话有效，就会不断的重试，直到删除成功为止
        client.delete().guaranteed().forPath("/America");
    }
}
