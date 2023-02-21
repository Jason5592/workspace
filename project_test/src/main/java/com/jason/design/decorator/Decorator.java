package com.jason.design.decorator;

import com.jason.design.proxy.Target;

/**
 * @author 王政
 * @date 2022/8/30 18:48
 */
public class Decorator implements Target {

    private Target target;

    public Decorator(Target target) {
        this.target = target;
    }

    @Override
    public void method() {
        before();
        target.method();
        after();
    }

    private void before() {
        System.out.println("before proxy!");
    }

    private void after() {
        System.out.println("after proxy!");
    }

}
