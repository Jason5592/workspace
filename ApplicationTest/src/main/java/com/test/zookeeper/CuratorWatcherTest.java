package com.test.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorWatcherTest {

    private static final CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.162.128:2180,192.168.162.128:2181," +
                    "192.168.162.128:2182,192.168.162.128:2183," +
                    "192.168.162.128:2184,192.168.162.128:2185")
            .sessionTimeoutMs(50000)
            .connectionTimeoutMs(30000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) throws Exception {
        /**
         * 创建会话
         */
        client.start();
//        client.create().creatingParentsIfNeeded().forPath("/book/computer", "java".getBytes());
        /**
         * 监听指定节点本身的变化,包括节点本身的创建和节点本身数据的变化
         */
        NodeCache nodeCache = new NodeCache(client, "/book/computer");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() {
                System.out.println("新的节点数据:" + new String(nodeCache.getCurrentData().getData()));
            }
        });
        nodeCache.start(true);

        Thread.sleep(5000);
//        client.setData().forPath("/book/computer", "c++".getBytes());
//        client.setData().forPath("/book/computer", "c#".getBytes());
        client.setData().forPath("/book/computer", "python".getBytes());
        /**
         * 监听子节点变化情况
         * 1 新增子节点
         * 2 删除子节点
         * 3 子节点数据变更
         */
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/book1", true);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) {
                switch (event.getType()) {
                    case CHILD_ADDED:
                        System.out.println("新增子节点:" + event.getData().getPath());
                        break;
                    case CHILD_UPDATED:
                        System.out.println("子节点数据变化:" + event.getData().getPath());
                        break;
                    case CHILD_REMOVED:
                        System.out.println("删除子节点:" + event.getData().getPath());
                        break;
                    default:
                        break;
                }
            }
        });
        pathChildrenCache.start();

//        client.create().forPath("/book1");

//        client.create().forPath("/book1/car", "bmw".getBytes());

//        client.setData().forPath("/book1/car", "honda".getBytes());

//        client.delete().forPath("/book1/car");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
