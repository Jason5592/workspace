package pattern.observer.java;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-23
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class Police extends Observable {

    private String time ;
    public Police(List<Observer> list) {
        super();
        for (Observer o:list) {
            addObserver(o);
        }
    }
    public void change(String time){
        this.time = time;
        setChanged();
        notifyObservers(this.time);
    }
}