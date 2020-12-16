package pattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 9:48
 * 场景类
 */
public class Context {
    private Strategy strategy;

    public Double calRecharge(Double charge, Integer type) {
        strategy = StrategyFactory.getInstance().creator(type);
        return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
