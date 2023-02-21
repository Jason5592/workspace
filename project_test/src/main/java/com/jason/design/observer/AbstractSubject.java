package com.jason.design.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 王政
 * @date 2022/8/31 16:12
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> elements = observers.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }

}
