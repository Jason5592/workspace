package com.jason.design.observer;

/**
 * @author 王政
 * @date 2022/8/31 16:11
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
    
}
