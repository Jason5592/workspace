package pattern.state;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:27
 * 定义一个接口，用以封装环境对象的一个特定的状态所对应的行为。
 */
public interface State {
    public void change(Context context);
}
