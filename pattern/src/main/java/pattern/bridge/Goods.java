package pattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 10:09
 * 货车运货
 */
public class Goods implements Transport{

    @Override
    public void transport() {

        System.out.println("运货");
    }

}
