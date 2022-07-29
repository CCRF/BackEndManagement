package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysUser;
import cn.edu.guet.backendmanagement.bean.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * 用户管理
 *
 * @Author Liwei
 * @Date 2021-08-13 18:03
 */
public interface SysUserService {

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    SysUser findByName(String username);

    List<SysUserRole> findUserRoles(Long userId);

    List<SysUser> findAllUser();

    boolean deleteUserById(String id);

    boolean updateUser(SysUser sysUser);

    boolean insertUser(SysUser sysUser);

    List<SysUser> findUserById(String id);

    List<SysUser> findUserByMsg(String msg);

}
