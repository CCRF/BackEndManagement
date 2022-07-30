package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.Order;
import cn.edu.guet.backendmanagement.mapper.SysOrderMapper;
import cn.edu.guet.backendmanagement.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Author:chenchaosheng
 * Date: 2022/7/30 10:17
 * Version: 1.0
 */
@Service
public class SysOrderServiceImpl implements SysOrderService {
    @Autowired
    private SysOrderMapper sysOrderMapper;
    @Override
    public List<Order> getCurrentOrder() {
        List<Order> currentOrder = sysOrderMapper.getCurrentOrder();
        return currentOrder;
    }

    @Override
    public List<Order> getHistoryOrder() {
        List<Order> historyOrder = sysOrderMapper.getHistoryOrder();
        return historyOrder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Integer modifyOrder(Order order) {
        Integer integer = sysOrderMapper.modifyOrder(order);
        return integer;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Integer deleteOrder(List<BigInteger> orderList) {
        Integer integer = sysOrderMapper.deleteOrder(orderList);
        return integer;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Integer insert(Order order) {
        Integer insert = sysOrderMapper.insert(order);
        return insert;
    }
}
