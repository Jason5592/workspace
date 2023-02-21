package com.jason.design.command;

/**
 * @author 王政
 * @date 2022/8/31 18:13
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }

}
