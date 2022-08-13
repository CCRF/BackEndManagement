package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysGoods;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    @PreAuthorize("hasAuthority('sys:goods:view')")
    public HttpResult findAllGoods() {
//        System.out.println(sysGoodsService.findAll());
        return HttpResult.ok(sysGoodsService.findAll());
    }

    @GetMapping("/selectGoodsById")
    @PreAuthorize("hasAuthority('sys:goods:view')")
    public HttpResult selectGoodsById(long id) {
        System.out.println(sysGoodsService.selectById(id));
        return HttpResult.ok(sysGoodsService.selectById(id));
    }

    @GetMapping("/selectGoodsByAllMsg")
    @PreAuthorize("hasAuthority('sys:goods:view')")
    public HttpResult selectGoodsByAllMsg(@RequestParam String isSale, @RequestParam String typeId, @RequestParam String price, @RequestParam String msg) {
//        System.out.println(sysGoodsService.selectByAllMsg(isSale, typeId, price, msg));
        return HttpResult.ok(sysGoodsService.selectByAllMsg(isSale, typeId, price, msg));
    }

    @PostMapping("/insertGoods")
    @PreAuthorize("hasAuthority('sys:goods:add')")
    public HttpResult insertGoods(@RequestBody ObjectNode json) {
//        System.out.println(id);
        return HttpResult.ok(sysGoodsService.insertGoods(json));
    }

    @PostMapping("/updateGoods")
    @PreAuthorize("hasAuthority('sys:goods:edit')")
    public HttpResult updateGoods(@RequestBody SysGoods sysGoods) {
//        System.out.println(id);
        return HttpResult.ok(sysGoodsService.updateGoods(sysGoods));
    }

    @PostMapping("/deleteGoods")
    @PreAuthorize("hasAuthority('sys:goods:delete')")
    public HttpResult deleteGoods(@RequestBody long id) {
        System.out.println(id);
        return HttpResult.ok(sysGoodsService.deleteGoodsById(id));
    }

    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('sys:goods:add')")
    public HttpResult uploadImage(@RequestParam MultipartFile file, @RequestParam String type) {
        System.out.println(file);
        try {
            String image = sysGoodsService.uploadImage(file, type);
            return HttpResult.ok(image);
        }
        catch (IOException e) {
            return HttpResult.error("文件上传失败");
        }
    }
}
