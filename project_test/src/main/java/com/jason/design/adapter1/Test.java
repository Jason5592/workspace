package com.jason.design.adapter1;

import com.jason.design.adapter3.Source;

/**
 * @author 王政
 * @date 2022/8/30 18:28
 */
public class Test {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.method1();
        target.method2();
    }

}
