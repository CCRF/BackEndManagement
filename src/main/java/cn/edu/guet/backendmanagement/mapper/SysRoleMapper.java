package cn.edu.guet.backendmanagement.mapper;

import java.util.Date;
import java.util.List;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import cn.edu.guet.backendmanagement.bean.SysRoleMenu;
import org.apache.ibatis.annotations.*;

/**
 * @author zhh
 * @Date 2022-07-30 11:25
 * @version 1.0
 */
@Mapper
public interface SysRoleMapper {
    SysRole selectByPrimaryKey(Long id);

    List<SysRole> findAll();


    @Select("select count(*) from sys_role_menu where role_id=#{id}")
    int count(Long id);


    @Update("update sys_role set del_flag=-1 where id=#{id}")
    void updateMsg(Long id);

    @Insert("insert into sys_role(name, remark, create_by, create_time, del_flag) values (#{name},#{remark},#{createBy},#{createTime},#{delFlag})")
    int addMsg(SysRole sysRole);


    @Select("select m.name from sys_menu as m,sys_role_menu as sm where sm.role_id=#{id} and m.id=sm.menu_id")
    List<SysMenu> getNewMsg(Long id);

    @Update("update sys_role set name=#{userName}, remark=#{remark},last_update_time=#{lastUpdateTime},last_update_by=#{lastUpdateBy} where id=#{id}")
    void updateName(String userName, String remark, Long id, Date lastUpdateTime,String lastUpdateBy);


    List<SysMenu> updateRoleMenu(@Param("list") List<String> nameList);


    @Select("select sys_role_menu.menu_id from sys_role_menu where role_id=#{id}")
    List<SysRoleMenu> selectRoleId(Long id);

    @Select("select * from sys_role_menu where role_id=#{id}")
    List<Integer> selectId( Long id);

    void insertRoleMenu(@Param("menuList") List<SysMenu> menuId,@Param("id") Long id);

    @Delete("delete from sys_role_menu where role_id=#{id}")
    void deleteRoleMenu(Long id);


    List<SysRole> searchMsg(@Param("msg") String msg);
}