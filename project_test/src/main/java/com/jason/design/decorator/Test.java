package com.jason.design.decorator;

import com.jason.design.proxy.Source;
import com.jason.design.proxy.Target;

/**
 * @author 王政
 * @date 2022/8/30 18:50
 */
public class Test {

    public static void main(String[] args) {
        Target source = new Source();
        Target decorator = new Decorator(source);
        decorator.method();
    }

}
