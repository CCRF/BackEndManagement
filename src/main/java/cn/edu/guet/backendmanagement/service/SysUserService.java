package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysUser;
import cn.edu.guet.backendmanagement.bean.SysUserRole;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * 用户管理
 *
 * @Author wangguijun
 * @Date 2022-08-01
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

    boolean deleteUserById(String id,String avatar);

    boolean updateUser(SysUser sysUser);

    boolean insertUser(SysUser sysUser);

    List<SysUser> findUserById(String id);

    List<SysUser> findUserByMsg(String msg);

    List<SysUser> findUserByName(String name);

    List<SysRole> findAllRole();

    String uploadImage(MultipartFile image) throws IOException;

    boolean deleteImg(String path);

    String imgName(String path);

}
