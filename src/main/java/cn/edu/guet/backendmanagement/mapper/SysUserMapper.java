package cn.edu.guet.backendmanagement.mapper;

import java.util.List;

import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wangguijun
 * @Date 2022-08-01 17:50
 */
@Mapper
public interface SysUserMapper {
    SysUser findByName(@Param(value = "name") String name);

    List<SysUser> findAllUser();

    boolean deleteUserById(String id);

    boolean updateUser(SysUser sysUser);

    boolean insertUser(SysUser sysUser);

    List<SysUser> findUserById(String id);

    List<SysUser> findUserByMsg(String msg);

    List<SysUser> findUserByName(String name);

    List<SysRole> findAllRole();





}
