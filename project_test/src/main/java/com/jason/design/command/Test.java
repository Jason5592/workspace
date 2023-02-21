package com.jason.design.command;

/**
 * @author 王政
 * @date 2022/8/31 18:15
 */
public class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);

        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
