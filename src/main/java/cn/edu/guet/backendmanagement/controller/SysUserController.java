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
 * @Author Liwei
 * @Date 2021-08-17 07:15
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
    public List<SysUser> findAllUser(){
        System.out.println("寻找用户"+sysUserService.findAllUser());
        List<SysUser> sysUsers =sysUserService.findAllUser();
        return sysUsers;
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable("id") String id){
        if(sysUserService.deleteUserById(id)){
            System.out.println("删除成功");
            return true;
        }else {
            return false;
        }
    }
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody SysUser sysUser){
        if(sysUserService.updateUser(sysUser)){
            System.out.println("更新成功");
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/insertUser")
    public boolean insertUser(@RequestBody SysUser sysUser){
        if(sysUserService.insertUser(sysUser)){
            System.out.println("插入成功");
            return true;
        }else {
            return false;
        }
    }

    @GetMapping("/findById/{id}")
    public List<SysUser> findUserById(@PathVariable("id") String id){

        return sysUserService.findUserById(id);
    }

    @GetMapping("/findUserByMsg/{msg}")
    public List<SysUser> findUserByMsg(@PathVariable("msg") String msg){
        String msgs="%"+msg+"%";
        return sysUserService.findUserByMsg(msgs);
    }
}
