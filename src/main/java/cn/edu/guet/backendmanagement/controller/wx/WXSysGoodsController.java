package cn.edu.guet.backendmanagement.controller.wx;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SetMealService;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import cn.edu.guet.backendmanagement.service.SysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: tlj
 * @Date: 2022/08/05/13:48
 * @Description:
 */

@RequestMapping("wx")
@RestController
public class WXSysGoodsController {


    @Autowired
    private SysGoodsService sysGoodsService;

    //微信小程序的查询所有餐品，餐品类型，
    @GetMapping("/findAllGoods")
    public HttpResult findAllGoods() {
        System.out.println(sysGoodsService.findAll());
        return HttpResult.ok(sysGoodsService.findAll());
    }

    @GetMapping("/findAllType")
    public HttpResult findAllType() {
        System.out.println(sysGoodsService.findAllType());
        return HttpResult.ok(sysGoodsService.findAllType());
    }

    //微信小程序查询所有套餐
    @Autowired
    private SetMealService service;

    @GetMapping("/findCombo")
    public HttpResult selectAllMeal() {
        List<SetMeal> meals = service.selectAllMeal();
        return HttpResult.ok(meals);
    }


    //接收微信小程序传来的订单信息
    @Autowired
    private SysOrderService sysOrderService;

    @PostMapping("/insert")
    public HttpResult insert(@RequestBody SysOrder order) {
        Integer insert;
//        System.out.println(order + "______________________");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        order.setStartTime(simpleDateFormat.format(new Date()));
        insert = sysOrderService.insert(order);
        if (insert == 1)
            if (order.getCustomerId().compareTo(new BigInteger("1")) == 0)
                return HttpResult.ok(sysOrderService.getCurrentOrder());
            else
                return HttpResult.ok(sysOrderService.getHistoryOrder());
        else return HttpResult.error("添加失败！");
    }

}
