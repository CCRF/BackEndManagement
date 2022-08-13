package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('sys:order:view')")
    public HttpResult getCurrentOrder() {
        List<SysOrder> currentOrder = sysOrderService.getCurrentOrder();
        return HttpResult.ok(currentOrder);
    }

    @RequestMapping("/getHistoryOrder")
    @PreAuthorize("hasAuthority('sys:order:view')")
    public HttpResult getHistoryOrder() {
        List<SysOrder> historyOrder = sysOrderService.getHistoryOrder();
        return HttpResult.ok(historyOrder);
    }

    @PostMapping("/modifyOrder")
    @PreAuthorize("hasAuthority('sys:order:edit')")
    public HttpResult modifyOrder(@RequestBody List<SysOrder> order) {
        AtomicReference<Integer> integer = new AtomicReference<>();
        integer.set(0);
        order.forEach(d -> {
            if (d != null) {
                integer.set(sysOrderService.modifyOrder(d));
            }
        });
        return HttpResult.ok(integer.get());
    }


    @PostMapping("/deleteOrder")
    @PreAuthorize("hasAuthority('sys:order:delete')")
    public HttpResult deleteOrder(@RequestBody Map<String, Object> map) {
        List orderList = (List) map.get("orderId");
        Integer integer = sysOrderService.deleteOrder(orderList);
        if (integer >= 1)
            if ((Integer) map.get("status") == 1)
                return HttpResult.ok(sysOrderService.getCurrentOrder());
            else
                return HttpResult.ok(sysOrderService.getHistoryOrder());
        else return HttpResult.error("删除失败！");
    }

    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('sys:order:add')")
    public HttpResult insert(@RequestBody SysOrder order) {
//        Integer insert;
////        System.out.println(order + "______________________");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        order.setStartTime(simpleDateFormat.format(new Date()));
//        insert = sysOrderService.insert(order);
//        if (insert == 1)
//            if (order.getCustomerId().compareTo(new BigInteger("1"))==0)
//                return HttpResult.ok(sysOrderService.getCurrentOrder());
//            else
//                return HttpResult.ok(sysOrderService.getHistoryOrder());
//        else return HttpResult.error("添加失败！");
        return null;
    }
}
