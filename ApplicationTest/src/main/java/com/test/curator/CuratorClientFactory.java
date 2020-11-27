package com.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CuratorClientFactory {

    private final String zkConnect;
    private final int sessionTimeout;
    private final int connectionSessionTimeout;
    private final int baseSleepTime;
    private final int maxRetries;

    public CuratorClientFactory(String zkConnect, int sessionTimeout, int connectionSessionTimeout, int baseSleepTime, int maxRetries) {
        this.zkConnect = zkConnect;
        this.sessionTimeout = sessionTimeout;
        this.connectionSessionTimeout = connectionSessionTimeout;
        this.baseSleepTime = baseSleepTime;
        this.maxRetries = maxRetries;
    }

    private volatile CuratorFramework curatorFramework;
    private final Object object = new Object();

    public CuratorFramework getCuratorFramework() throws InterruptedException {
        verifyParams(zkConnect, sessionTimeout, connectionSessionTimeout, baseSleepTime, maxRetries);
        if (curatorFramework == null) {
            synchronized (object) {
                if (curatorFramework == null) {
                    curatorFramework = CuratorFrameworkFactory.newClient(zkConnect,
                            sessionTimeout,connectionSessionTimeout, new ExponentialBackoffRetry(baseSleepTime, maxRetries));
                }
            }
        }
        curatorFramework.start();
        curatorFramework.blockUntilConnected();
        return curatorFramework;
    }

    static class Builder {

        private String zkConnect;
        private int sessionTimeout;
        private int connectionSessionTimeout;
        private int baseSleepTime;
        private int maxRetries;

        public Builder zkConnect(String zkConnect) {
            this.zkConnect = zkConnect;
            return this;
        }

        public Builder sessionTimeout(int sessionTimeout) {
            this.sessionTimeout = sessionTimeout;
            return this;
        }

        public Builder connectionSessionTimeout(int connectionSessionTimeout) {
            this.connectionSessionTimeout = connectionSessionTimeout;
            return this;
        }

        public Builder baseSleepTime(int baseSleepTime) {
            this.baseSleepTime = baseSleepTime;
            return this;
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public CuratorClientFactory build() {
            verifyParams(zkConnect, sessionTimeout, connectionSessionTimeout, baseSleepTime, maxRetries);
            return new CuratorClientFactory(zkConnect, sessionTimeout, connectionSessionTimeout, baseSleepTime, maxRetries);
        }
    }

    private static void verifyParams(String zkConnect, int sessionTimeout, int connectionSessionTimeout, int baseSleepTime, int maxRetries) {
        Assert.notNull(zkConnect, "zkConnect empty");
        if (sessionTimeout <= 0) {
            throw new IllegalArgumentException("sessionTimeout <= 0");
        }
        if (connectionSessionTimeout <= 0) {
            throw new IllegalArgumentException("connectionSessionTimeout <= 0");
        }
        if (baseSleepTime <= 0) {
            throw new IllegalArgumentException("baseSleepTime <= 0");
        }
        if (maxRetries <= 0) {
            throw new IllegalArgumentException("maxRetries <= 0");
        }
    }
}
