package com.jason.design.proxy;

/**
 * @author 王政
 * @date 2022/8/30 18:51
 */
public class Proxy implements Target {

    private Target source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before() {
        System.out.println("before proxy!");
    }

    private void after() {
        System.out.println("after proxy!");
    }

}
