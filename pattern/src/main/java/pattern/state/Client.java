package pattern.state;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:30
 * http://alaric.iteye.com/blog/1938400
 */
public class Client {
    public static void main(String[] args) {
        State state = new ConcreteStateA();
        Context context = new Context(state);
        //初始状态是A
        context.change();
        //装换一次后变成B
        context.change();
        //再转换一次后又变成A
        context.change();
    }
}
