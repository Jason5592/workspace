package pattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 9:45
 * 网银充值策略实现
 */
public class EBankStrategy implements Strategy {

    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge * 0.85;
    }


}
