package pattern.observer.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-23
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) {
        UndercoverA o1 = new UndercoverA();
        UndercoverB o2 = new UndercoverB();
        List<Observer> list = new ArrayList<Observer>();
        list.add(o1);
        list.add(o2);
        Police subject = new Police(list);
        subject.change("02:25");
        System.out.println("===========由于消息败露，行动时间提前=========");
        subject.change("01:05");
    }
}
