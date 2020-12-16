package pattern.memento;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:17
 * 备忘录角色
 * <p/>
 * 备忘录(Memento)：负责存储Originator对象的内部状态，并可以防止Originator以外的其他对象访问备忘录。
 * 备忘录有两个接口：Caretaker只能看到备忘录的窄接口，他只能将备忘录传递给其他对象。
 * Originator却可看到备忘录的宽接口，允许它访问返回到先前状态所需要的所有数据。
 * <p/>
 * 及一个数据块，或者对象
 */
public class Memento implements  IMemento{
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
