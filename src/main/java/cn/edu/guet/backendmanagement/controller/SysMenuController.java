package cn.edu.guet.backendmanagement.controller;

import java.util.List;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单控制器
 *
 * @Author Liwei
 * @Date 2021-08-16 09:20
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

//    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        System.out.println("查找菜单树：" + userName);
        List<SysMenu> sysMenus = sysMenuService.findTree(userName, 1);
        return HttpResult.ok(sysMenus);
    }

    @GetMapping(value = "/findAllNavTree")
    public HttpResult findAllNavTree(@RequestParam String userName) {

        List<SysMenu> sysMenus = sysMenuService.findTree(userName, 0);
        return HttpResult.ok(sysMenus);
    }


    @GetMapping("findAll/{page}/{size}")
    public HttpResult finaAll(@PathVariable int page, @PathVariable int size){

        PageBean<SysMenu> pageBean = sysMenuService.findAll(page,size);


        return HttpResult.ok(pageBean);
    }
}
