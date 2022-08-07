package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @GetMapping("/selectGoodsById")
    public HttpResult selectGoodsById(long id) {
        System.out.println(sysGoodsService.selectById(id));
        return HttpResult.ok(sysGoodsService.selectById(id));
    }

    @GetMapping("/selectGoodsByIsSale")
    public HttpResult selectGoodsByIsSale(@RequestParam int isSale) {
        System.out.println(sysGoodsService.selectByIsSale(isSale));
        return HttpResult.ok(sysGoodsService.selectByIsSale(isSale));
    }

    @GetMapping("/selectGoodsByType")
    public HttpResult selectGoodsByType(@RequestParam long typeId) {
        System.out.println(sysGoodsService.selectByType(typeId));
        return HttpResult.ok(sysGoodsService.selectByType(typeId));
    }

    @GetMapping("/selectGoodsByPrice")
    public HttpResult selectGoodsByPrice(@RequestParam double price) {
        System.out.println(sysGoodsService.selectByPrice(price));
        return HttpResult.ok(sysGoodsService.selectByPrice(price));
    }

    @GetMapping("/selectGoodsByMsg")
    public HttpResult selectGoodsByMsg(@RequestParam String msg) {
        System.out.println(sysGoodsService.selectByMsg(msg));
        return HttpResult.ok(sysGoodsService.selectByMsg(msg));
    }

    @GetMapping("/selectGoodsByAllMsg")
    public HttpResult selectGoodsByAllMsg(@RequestParam String isSale, @RequestParam String typeId, @RequestParam String price, @RequestParam String msg) {
        System.out.println(sysGoodsService.selectByAllMsg(isSale, typeId, price, msg));
        return HttpResult.ok(sysGoodsService.selectByAllMsg(isSale, typeId, price, msg));
    }

    @PostMapping("/insertGoods")
    public HttpResult insertGoods(@RequestBody ObjectNode json) {
//        System.out.println(id);
        return HttpResult.ok(sysGoodsService.insertGoods(json));
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
