package pattern.state;

/**
 * User: stream
 * Date: 13-9-25
 * Time: 17:27
 * 场景（Context）角色：定义客户端所感兴趣的接口，并且保留一个具体状态类的实例。
 * 这个具体状态类的实例给出此环境对象现有的状态。
 */
public class Context {

    private State state;

    public void change() {
        state.change(this);
    }


    public Context(State state) {
        super();
        this.state = state;
    }


    public State getState() {
        return state;
    }


    public void setState(State state) {
        this.state = state;
    }
}
