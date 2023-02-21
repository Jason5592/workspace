package com.jason.design.observer;

/**
 * @author 王政
 * @date 2022/8/31 16:11
 */
public interface Subject {

    /*增加观察者*/
    void add(Observer observer);

    /*删除观察者*/
    void remove(Observer observer);

    /*通知所有的观察者*/
    void notifyObservers();

    /*自身的操作*/
    void operation();

}
