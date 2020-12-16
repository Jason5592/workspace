package pattern.memento;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:21
 */
public class Client {
    public static void main(String[] args) {

        Originator o = new Originator();
        Caretaker c = new Caretaker();

        //改变发起人的状态
        o.setState("on");
        //创建备忘录对象，并保持于管理保持
        c.saveMemento(o.createMemento());
        //改变发起人的状态
        o.setState("off");
        //还原状态
        o.restoreMemento(c.retrieveMemento());
    }
}
