package com.jason.design.state;

/**
 * @author 王政
 * @date 2022/9/1 14:45
 */
public class Test {

    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }

}
