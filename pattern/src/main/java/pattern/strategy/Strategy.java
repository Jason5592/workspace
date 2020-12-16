package pattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public interface Strategy {

    /**
     * 描述：策略行为方法
     */
    public Double calRecharge(Double charge, RechargeTypeEnum type);
}
