package pattern.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-23
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class UndercoverA implements Observer {

    private String time;
    @Override
    public void update(Observable o, Object arg) {
        time = (String) arg;
        System.out.println("卧底A接到消息，行动时间为："+time);
    }


}