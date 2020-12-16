package pattern.memento;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:19
 * 负责创建一个备忘录Memento，用以记录当前时刻自身的内部状态，并可使用备忘录恢复内部状态。
 * Originator可以根据需要决定Memento存储自己的哪些内部状态。
 */
public class Originator {

    //自己的内容
    private String state;

    public IMemento createMemento() {
        //将内容放入
        return new Memento(state);
    }

    /**
     * 描述：还原
     */
    public void restoreMemento(IMemento memento) {
        //this.state = memento.getState();
        Memento m = (Memento) memento;
        setState(m.getState());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("current state:"+state);
    }
}