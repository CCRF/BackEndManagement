package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysOrder;

import java.math.BigInteger;
import java.util.List;
/**
 * Author:chenchaosheng
 * Date: 2022/7/30 10:17
 * Version: 1.0
 */
public interface SysOrderService {
    List<SysOrder> getCurrentOrder();
    List<SysOrder> getHistoryOrder();
    Integer modifyOrder(SysOrder order);
    Integer deleteOrder(List<BigInteger> orderList);
    Integer insert(SysOrder order);
}
