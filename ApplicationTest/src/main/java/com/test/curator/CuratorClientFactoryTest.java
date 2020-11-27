package com.test.curator;

import org.apache.curator.framework.CuratorFramework;

public class CuratorClientFactoryTest {

    public static void main(String[] args) throws Exception {
        String zkConnect = "192.168.162.128:2180,192.168.162.128:2181," +
                "192.168.162.128:2182,192.168.162.128:2183," +
                "192.168.162.128:2184,192.168.162.128:2185";
        int sessionTimeout = 50000;
        int connectionSessionTimeout = 30000;
        int baseSleepTime = 3000;
        int maxRetries = 5;
        CuratorClientFactory curatorClientFactory = new CuratorClientFactory.Builder()
                .zkConnect(zkConnect)
                .sessionTimeout(sessionTimeout)
                .connectionSessionTimeout(connectionSessionTimeout)
                .baseSleepTime(baseSleepTime)
                .maxRetries(maxRetries).build();
        CuratorFramework curatorFramework = curatorClientFactory.getCuratorFramework();
        String result = curatorFramework.create().forPath("/test1");
        System.out.println(result);

        curatorFramework.getData().watched().forPath("/test1");
    }
}
