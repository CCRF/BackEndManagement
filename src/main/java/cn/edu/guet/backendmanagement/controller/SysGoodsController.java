package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(sysGoodsService.findAll());
        return HttpResult.ok(sysGoodsService.findAll());
    }
}
