package com.jason.design.adapter2;

/**
 * @author 王政
 * @date 2022/8/30 18:31
 * 对象的适配器模式
 */
public class Wrapper implements Target {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the target method!");
    }

}
