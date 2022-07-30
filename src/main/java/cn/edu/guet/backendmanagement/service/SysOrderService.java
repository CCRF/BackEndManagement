package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.math.BigInteger;
import java.util.List;
/**
 * Author:chenchaosheng
 * Date: 2022/7/30 10:17
 * Version: 1.0
 */
public interface SysOrderService {
    List<Order> getCurrentOrder();
    List<Order> getHistoryOrder();
    Integer modifyOrder(Order order);
    Integer deleteOrder(List<BigInteger> orderList);
    Integer insert(Order order);
}
