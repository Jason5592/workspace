package com.jason.design.observer;

/**
 * @author 王政
 * @date 2022/8/31 17:18
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }

}
