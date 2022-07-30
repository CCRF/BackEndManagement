package cn.edu.guet.backendmanagement.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysUser;
import cn.edu.guet.backendmanagement.bean.SysUserRole;
import cn.edu.guet.backendmanagement.mapper.SysRoleMapper;
import cn.edu.guet.backendmanagement.mapper.SysUserMapper;
import cn.edu.guet.backendmanagement.mapper.SysUserRoleMapper;
import cn.edu.guet.backendmanagement.service.SysMenuService;
import cn.edu.guet.backendmanagement.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liwei
 * @Date 2021-08-13 18:12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public SysUser findByName(String name) {
        SysUser sysUser = sysUserMapper.findByName(name);
        if (sysUser != null) {
            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
            return sysUser;
        }
        return null;
    }

    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext(); ) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
            if (sysRole == null) {
                continue;
            }
            sb.append(sysRole.getRemark());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public List<SysUser> findAllUser() {

        return sysUserMapper.findAllUser();
    }

    @Override
    public boolean deleteUserById(String id) {
        if(sysUserMapper.deleteUserById(id)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateUser(SysUser sysUser) {
        if(sysUserMapper.updateUser(sysUser)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean insertUser(SysUser sysUser) {
        if(sysUserMapper.insertUser(sysUser)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<SysUser> findUserById(String id) {
        return sysUserMapper.findUserById(id);
    }

    @Override
    public List<SysUser> findUserByMsg(String msg) {
        return sysUserMapper.findUserByMsg(msg);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        System.out.println("获取用户权限菜单: "+userName);
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(userName);
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }
}
