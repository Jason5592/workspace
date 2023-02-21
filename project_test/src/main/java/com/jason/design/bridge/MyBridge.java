package com.jason.design.bridge;

/**
 * @author 王政
 * @date 2022/8/31 10:52
 */
public class MyBridge extends Bridge {

    @Override
    public void method() {
        getSource().method();
    }

}
