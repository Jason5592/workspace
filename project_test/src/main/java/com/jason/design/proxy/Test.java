package com.jason.design.proxy;

/**
 * @author 王政
 * @date 2022/8/30 18:52
 */
public class Test {

    public static void main(String[] args) {
        Target target = new Proxy();
        target.method();
    }

}
