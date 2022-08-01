package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysUser;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 用户控制器
 *
 * @Author wangguijun
 * @Date 2022-08-01
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        System.out.println("查找权限："+name);
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @GetMapping(value = "/findAllUser")
    public HttpResult findAllUser(){
        List<SysUser> sysUsers =sysUserService.findAllUser();
        return HttpResult.ok(sysUsers);
    }

    @DeleteMapping("/deleteUser/{id}")
    public HttpResult deleteUser(@PathVariable("id") String id){
        boolean isTrue = sysUserService.deleteUserById(id);
        if(isTrue){
            System.out.println("删除成功");
            return HttpResult.ok(true);
        }else {
            return HttpResult.ok(false);
        }
    }
    @PostMapping("/updateUser")
    public HttpResult updateUser(@RequestBody SysUser sysUser){
        boolean isTrue = sysUserService.updateUser(sysUser);
        if(isTrue){
            System.out.println("删除成功");
            return HttpResult.ok(true);
        }else {
            return HttpResult.ok(false);
        }
    }

    @PostMapping("/insertUser")
    public HttpResult insertUser(@RequestBody SysUser sysUser){
        boolean isTrue = sysUserService.insertUser(sysUser);
        if(isTrue){
            System.out.println("删除成功");
            return HttpResult.ok(true);
        }else {
            return HttpResult.ok(false);
        }
    }

    @GetMapping("/findById/{id}")
    public HttpResult findUserById(@PathVariable("id") String id){
        List<SysUser> sysUsers = sysUserService.findUserById(id);
        return HttpResult.ok(sysUsers);
    }

    @GetMapping("/findUserByMsg/{msg}")
    public HttpResult findUserByMsg(@PathVariable("msg") String msg){
        String msgs="%"+msg+"%";
        List<SysUser> sysUsers = sysUserService.findUserByMsg(msgs);
        return HttpResult.ok(sysUsers);
    }

    @GetMapping("/findUserByName/{name}")
    public HttpResult findUserByName(@PathVariable("name") String name){
        List<SysUser> sysUsers = sysUserService.findUserByName(name);
        return HttpResult.ok(sysUsers);
    }

    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/findAllRole")
    public HttpResult findAll() {
        return HttpResult.ok(sysUserService.findAllRole());
    }


}


