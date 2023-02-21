package com.jason.design.chainOfResponsibility;

/**
 * @author 王政
 * @date 2022/8/31 17:58
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println(name + " deal!");
        Handler handler = getHandler();
        if (handler != null) {
            handler.operate();
        }
    }

}
