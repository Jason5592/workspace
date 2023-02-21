package com.jason.design.chainOfResponsibility;

/**
 * @author 王政
 * @date 2022/8/31 17:59
 */
public class Test {

    public static void main(String[] args) {
        MyHandler handler1 = new MyHandler("A");
        MyHandler handler2 = new MyHandler("B");
        MyHandler handler3 = new MyHandler("C");

        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.operate();
    }

}
