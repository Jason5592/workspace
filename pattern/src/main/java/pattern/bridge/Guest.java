package pattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 10:09
 *
 */
public class Guest implements Transport{

    @Override
    public void transport() {

        System.out.println("运客");

    }

}