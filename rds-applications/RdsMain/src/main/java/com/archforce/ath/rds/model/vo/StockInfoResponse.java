package com.archforce.ath.rds.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StockInfoResponse implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 消息类型
     *   ORIGINAL_MESSAGE = 0; // 原消息兼容格式
     *   ORDER_MESSAGE = 1; // 订单消息
     *   REPORT_MESSAGE = 2; // 回报消息
     *   OUT_QUERY_MESSAGE = 3; // 外部查询消息
     *   MARKET_MESSAGE = 4; // 行情消息
     *   FUNCTION_MESSAGE = 5; // 时间片、探测、登出登出等功能消息
     *   REAL_TIME_COMMAND_MESSAGE = 6; // 实时指令消息
     *   REPEAL_ORDER_MESSAGE = 7; // 撤单消息
     *   CUSTOMIZE_MESSAGE = 8; // 定制化消息
     */
    private int messageType;
    /**
     * 客户号
     */
    private String custId; // 客户号
    /**
     * 资金账号
     */
    private String fundAccountId;
    /**
     * 股东代码
     */
    private String accountId;
    /**
     * 用户系统消息序号
     */
    private long clientSeqId;
    /**
     * 查询结果代码
     */
    private int queryResultCode;
    /**
     * 用户私有信息
     */
    private String userInfo;
    /**
     * 条目索引号 最后一笔查询结果的索引号,当"lastIndex+1=totalNum"时表示已经查询到最后的记录;组合个数为0时,该值为-1
     */
    private long lastIndex;
    /**
     * 条目总数
     */
    private long totalNum;
    /**
     * 股份持仓信息列表
     */
    private List<StockInfo> stockInfos;
}
