package com.jason.design.adapter1;


/**
 * @author 王政
 * @date 2022/8/30 18:26
 * 类的适配器模式
 */
public class Adapter extends Source implements Target {

    @Override
    public void method2() {
        System.out.println("this is the target method!");
    }

}
