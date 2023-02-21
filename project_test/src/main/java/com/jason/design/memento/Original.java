package com.jason.design.memento;

/**
 * @author 王政
 * @date 2022/8/31 18:26
 */
public class Original {

    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restoreMemento(Memento memento) {
        value = memento.getValue();
    }

}
