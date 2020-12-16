package pattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:46
 */
public class ConcreteVisitorB implements Visitor{

    @Override
    public void visit(ConcreteElementB able) {
        able.operate();
    }

    @Override
    public void visit(ConcreteElementA able) {
        able.operate();
    }



}
