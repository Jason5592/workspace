package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-9-25
 * Time: 17:47
 * 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作。
 * http://alaric.iteye.com/blog/1942517
 */
public class Client {
    public static void main(String[] args) {

        Visitor v1 = new ConcreteVisitorA();
        List<Visitable> list = new ArrayList<Visitable>();
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());


        for(Visitable able :list){
            //访问者 访问元素， 元素接受一个访问者访问
            able.accept(v1);

        }

    }
}
