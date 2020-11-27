package com.test.jmx;

public interface HelloMBean {

    // management attributes
    String getName();
    void setName(String name);
    // management operations
    void print();
}
