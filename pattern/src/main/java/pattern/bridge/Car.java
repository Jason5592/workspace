package pattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 10:07
 * 汽车的实现类
 */
public class Car extends Vehicle {

    @Override
    public void transport() {

        System.out.print("汽车");
        super.transport();
    }

}
