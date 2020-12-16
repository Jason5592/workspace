package pattern.memento;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:20
 */
public class Caretaker {

    private IMemento memento;


    /**
     * 描述：取值
     */
    public IMemento retrieveMemento() {
        return memento;
    }

    /**
     * 描述：设置
     */
    public void saveMemento(IMemento memento) {
        this.memento = memento;
    }
}
