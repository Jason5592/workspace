package pattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:45
 * 具体元素B
 */
public class ConcreteElementB implements Visitable {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void operate(){
        System.out.println("ConcreteElementB ....");
    }
}
