package pattern.state;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class ConcreteStateB implements State {

    @Override
    public void change(Context context) {
        System.out.println("this is ConcreteStateB");
        context.setState(new ConcreteStateA());
    }
}
