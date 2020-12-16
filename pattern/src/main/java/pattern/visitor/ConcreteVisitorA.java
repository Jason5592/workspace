package pattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:43
 * 具体访问者A
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementB able) {
        able.operate();
    }

    @Override
    public void visit(ConcreteElementA able) {
        // TODO Auto-generated method stub
        able.operate();
    }
}
