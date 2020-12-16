package pattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 10:08
 * 火车的实现类
 */
public class Train extends Vehicle {

    @Override
    public void transport() {

        System.out.print("火车");
        super.transport();
    }

}
