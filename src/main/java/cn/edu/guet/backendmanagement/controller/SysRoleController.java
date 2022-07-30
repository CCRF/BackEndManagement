package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysRoleService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色控制器
 *
 * @author Liwei
 * @Date 2021-08-15 11:25
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @PreAuthorize("hasAuthority('sys:role:delete')")
    @DeleteMapping("deleteMsg/{id}")
    public HttpResult deleteMsg(@PathVariable Long id) {

        System.out.println(id);
        HttpResult httpResult = sysRoleService.deleteMsg(id);

        return httpResult;
    }

    @PreAuthorize("hasAuthority('sys:user:add')")
    @PostMapping("addMsg")
    public HttpResult addMsg(@RequestBody SysRole sysRole) {

        if (sysRole.getRemark().equals("") & sysRole.getName().equals("")){
            return HttpResult.error("输入内容不能为空");
        }else {
            int row = sysRoleService.addMsg(sysRole);

            return row > 0 ? HttpResult.ok("添加成功") : HttpResult.error("添加失败");
        }
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @GetMapping("getNewMsg/{id}")
    public HttpResult getNewMsg(@PathVariable Long id) {
        return HttpResult.ok(sysRoleService.getNewMsg(id));
    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @PostMapping("updateName")
    public HttpResult updateName(@RequestBody SysRole sysRole) {

        if (sysRole.getRemark().equals("") & sysRole.getName().equals("")){
            return HttpResult.error("输入内容不能为空");
        }else {
            HttpResult httpResult = sysRoleService.updateName(sysRole);

            return httpResult;
        }

    }

    @PreAuthorize("hasAuthority('sys:user:edit')")
    @PostMapping("updateRoleMenu/{id}")
    public HttpResult updateRoleMenu(@RequestBody List<String> nameList, @PathVariable Long id) {


        /*List<String> menuList = new ArrayList<>(Arrays.asList(nameList));*/

        HttpResult httpResult = sysRoleService.updateRoleMenu(nameList, id);

        return httpResult;
    }

    @PreAuthorize("hasAuthority('sys:role:view')")
    @PostMapping(value = "/searchMsg")
    public HttpResult searchMsg(@RequestBody String searchMsg) {
        String msg="%"+searchMsg+"%";
        return HttpResult.ok(sysRoleService.searchMsg(msg));
    }


}
