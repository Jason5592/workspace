package com.jason.design.adapter2;


/**
 * @author 王政
 * @date 2022/8/30 18:28
 */
public class Test {

    public static void main(String[] args) {
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();
    }

}
