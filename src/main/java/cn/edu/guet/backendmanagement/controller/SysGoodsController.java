package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HHS
 * @date 2022/08/03 22:23
 */
@RestController
@RequestMapping("goods")
public class SysGoodsController {

    @Autowired
    private SysGoodsService sysGoodsService;

    @GetMapping("/findAllGoods")
    public HttpResult findAllGoods() {
//        System.out.println(sysGoodsService.findAll());
        return HttpResult.ok(sysGoodsService.findAll());
    }

    @GetMapping("/selectGoodsByIsSale")
    public HttpResult selectGoodsByIsSale(@RequestParam int isSale) {
        System.out.println(sysGoodsService.selectByIsSale(isSale));
        return HttpResult.ok(sysGoodsService.selectByIsSale(isSale));
    }

    @GetMapping("/selectGoodsByType")
    public HttpResult selectGoodsByType(@RequestParam String typeName) {
        System.out.println(sysGoodsService.selectByType(typeName));
        return HttpResult.ok(sysGoodsService.selectByType(typeName));
    }

    @GetMapping("/selectGoodsByPrice")
    public HttpResult selectGoodsByPrice(@RequestParam double price) {
        System.out.println(sysGoodsService.selectByPrice(price));
        return HttpResult.ok(sysGoodsService.selectByPrice(price));
    }

    @GetMapping("/selectGoodsByMsg")
    public HttpResult selectGoodsByMsg(@RequestParam String msg) {
        msg = "%" + msg + "%";
        System.out.println(sysGoodsService.selectByMsg(msg));
        return HttpResult.ok(sysGoodsService.selectByMsg(msg));
    }

    @PostMapping("/deleteGoods")
    public HttpResult deleteGoods(@RequestBody long id) {
        System.out.println(id);
        return HttpResult.ok(sysGoodsService.deleteGoodsById(id));
    }

    @GetMapping("/findAllType")
    public HttpResult findAllType() {
        System.out.println(sysGoodsService.findAllType());
        return HttpResult.ok(sysGoodsService.findAllType());
    }
}
