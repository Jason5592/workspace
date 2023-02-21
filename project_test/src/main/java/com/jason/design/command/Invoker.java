package com.jason.design.command;

/**
 * @author 王政
 * @date 2022/8/31 18:12
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

}
