package pattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:43
 * 抽象访问者
 */
public interface Visitor {
    public void visit(ConcreteElementB able);
    public void visit(ConcreteElementA able);
}
