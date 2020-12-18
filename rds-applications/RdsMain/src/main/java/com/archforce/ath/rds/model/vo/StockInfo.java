package com.archforce.ath.rds.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockInfo implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 证券代码
     */
    private String securityId;
    /**
     * 证券简称
     */
    private String securitySymbol;
    /**
     * 市场
     */
    private String market;
    /**
     * 股东代码
     */
    private String accountId;
    /**
     * 日初持仓量
     */
    private long initQty;
    /**
     * 剩余股份数量
     */
    private long leftQty;
    /**
     * 可用股份数量
     */
    private long availableQty;
    /**
     * 浮动盈亏
     */
    private long profitLoss;
    /**
     * 市值
     */
    private long marketValue;
    /**
     * 成本价 元/每张
     */
    private long costPrice;
    /**
     * 日初融券买入量
     */
    private long initCrdSellBuyShareQty;
    /**
     * 日初融券占用金额
     */
    private long initCrdSellOccupiedAmt;
    /**
     * 当前融券买入量
     */
    private long curCrdSellOccupiedQty;
    /**
     * 当前融券占用金额
     */
    private long curCrdSellOccupiedAmt;
}
