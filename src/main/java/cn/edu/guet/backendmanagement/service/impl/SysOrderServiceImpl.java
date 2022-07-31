package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysOrder;
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
    public List<SysOrder> getCurrentOrder() {
        List<SysOrder> currentOrder = sysOrderMapper.getCurrentOrder();
        return currentOrder;
    }

    @Override
    public List<SysOrder> getHistoryOrder() {
        List<SysOrder> historyOrder = sysOrderMapper.getHistoryOrder();
        return historyOrder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public Integer modifyOrder(SysOrder order) {
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
    public Integer insert(SysOrder order) {
        Integer insert = sysOrderMapper.insert(order);
        return insert;
    }
}
