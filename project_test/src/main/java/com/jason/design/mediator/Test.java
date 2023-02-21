package com.jason.design.mediator;

/**
 * @author 王政
 * @date 2022/9/1 16:19
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }

}
