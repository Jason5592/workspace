package pattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 9:47
 * To change this template use File | Settings | File Templates.
 */
public class CardStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge + charge * 0.01;
    }

}
