package pattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:42
 * 抽象角色元素
 */
public interface Visitable {
    public void accept(Visitor v);
}
