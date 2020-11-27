package com.test.jmx;

public class Hello implements HelloMBean {

    private volatile String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("Hello, " + name + "!!");
    }

    @Override
    public void print() {

    }
}
