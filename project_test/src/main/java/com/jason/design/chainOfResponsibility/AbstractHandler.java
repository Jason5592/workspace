package com.jason.design.chainOfResponsibility;

/**
 * @author 王政
 * @date 2022/8/31 17:56
 */
public abstract class AbstractHandler implements Handler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
