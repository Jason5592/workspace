package com.test.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ZookeeperClient {

    public static final String ZK_SERVERS = "10.0.0.244:2183,10.0.0.244:2181,10.0.0.244:2182";
    public static final int SESSION_TIMEOUT = 5000;
    public static final String ZK_NODE = "/zk-node";
    private ZooKeeper zooKeeper;

    @Before
    public void init() throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(ZK_SERVERS, SESSION_TIMEOUT, event -> {
            if (event.getState() == Watcher.Event.KeeperState.SyncConnected &&
                    event.getType() == Watcher.Event.EventType.None) {
                countDownLatch.countDown();
                log.info("连接成功！");
            }
        });
        log.info("连接中...");
        countDownLatch.await();
    }

    @Test
    public void createNode() {
        try {
            zooKeeper.create(ZK_NODE + "4", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.error("创建节点成功！");
        } catch (Exception e) {
            log.error("创建节点失败！", e);
        }
    }

    @Test
    public void asyncCreateNode() {
        String node = "/async-node";
        try {
            zooKeeper.create(node, "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,
                    (rc, path, ctx, name) -> log.info("rc {},path {},ctx {},name{}", rc, path, ctx, name), "context");
            log.error("创建节点成功！");
        } catch (Exception e) {
            log.error("创建节点失败！", e);
        }
    }

    @Test
    public void setNode() throws Exception {
        String node = "/test";
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData(node, false, stat);
        log.info("修改前:{}", new String(data));
        zooKeeper.setData(node, "hello".getBytes(), stat.getVersion());
        byte[] dataAfter = zooKeeper.getData(node, false, stat);
        log.info("修改后:{}", new String(dataAfter));
    }
}
