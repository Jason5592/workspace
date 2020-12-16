package pattern.state;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:30
 * 具体状态
 */
public class ConcreteStateA implements State {

    @Override
    public void change(Context context) {
        System.out.println("this is ConcreteStateA");
        context.setState(new ConcreteStateB());
    }
}
