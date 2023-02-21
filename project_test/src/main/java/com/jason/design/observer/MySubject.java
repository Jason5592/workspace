package com.jason.design.observer;

/**
 * @author 王政
 * @date 2022/8/31 17:17
 */
public class MySubject extends AbstractSubject implements Subject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}
