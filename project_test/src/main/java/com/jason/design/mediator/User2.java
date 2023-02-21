package com.jason.design.mediator;

/**
 * @author 王政
 * @date 2022/9/1 16:18
 */
public class User2 extends User {

    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }

}
