package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.Order;
import cn.edu.guet.backendmanagement.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author:chenchaosheng
 * Date: 2022/7/30 10:17
 * Version: 1.0
 */
@RestController
@RequestMapping("/order")
public class SysOrderController {
    @Autowired
    private SysOrderService sysOrderService;

    @RequestMapping("/getCurrentOrder")
    public List<Order> getCurrentOrder() {
        List<Order> currentOrder = sysOrderService.getCurrentOrder();
        return currentOrder;
    }

    @RequestMapping("/getHistoryOrder")
    public List<Order> getHistoryOrder() {
        List<Order> historyOrder = sysOrderService.getHistoryOrder();
        return historyOrder;
    }

    @PostMapping("/modifyOrder")
    public Integer modifyOrder(@RequestBody List<Order> order) {
        AtomicReference<Integer> integer = new AtomicReference<>();
        integer.set(0);
        order.forEach(d -> {
            if (d != null) {
                integer.set(sysOrderService.modifyOrder(d));
            }
        });
        return integer.get();
    }


    @PostMapping("/deleteOrder")
    public List<Order> deleteOrder(@RequestBody Map<String, Object> map) {
        List orderList = (List) map.get("orderId");
        Integer integer = sysOrderService.deleteOrder(orderList);
        if (integer >= 1)
            if ((Integer) map.get("status") == 1)
                return sysOrderService.getCurrentOrder();
            else
                return sysOrderService.getHistoryOrder();
        else return null;
    }

    @PostMapping("/insert")
    public List<Order> insert(@RequestBody Order order) {
        Integer insert = null;
        System.out.println(order + "______________________");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        order.setStartTime(simpleDateFormat.format(new Date()));
        insert = sysOrderService.insert(order);
        if (insert == 1)
            if (order.getCustomerId().compareTo(new BigInteger("1"))==0)
                return sysOrderService.getCurrentOrder();
            else
                return sysOrderService.getHistoryOrder();
        else return null;
    }
}
