package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 */
public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory() {
    }

    private static Map<Integer, Strategy> strategyMap = new HashMap<Integer, Strategy>();

    static {
        strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
        strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
    }

    public Strategy creator(Integer type) {
        return strategyMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }
}
