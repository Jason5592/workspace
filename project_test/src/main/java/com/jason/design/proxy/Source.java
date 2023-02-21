package com.jason.design.proxy;

/**
 * @author 王政
 * @date 2022/8/30 18:48
 */
public class Source implements Target {

    @Override
    public void method() {
        System.out.println("the original method!");
    }

}
