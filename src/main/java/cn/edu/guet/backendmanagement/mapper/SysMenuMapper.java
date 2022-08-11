package cn.edu.guet.backendmanagement.mapper;

import java.util.Date;
import java.util.List;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import org.apache.ibatis.annotations.*;

/**
 * @version 1.0
 * @Author zhh
 * @Date 2022-08-10 17:50
 */
@Mapper
public interface SysMenuMapper {
    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param(value = "userName") String userName);


    List<SysMenu> searchMsg(@Param("msg") String msg);


    @Select("select * from sys_menu where del_flag!=-1")
    List<SysMenu> count();

    @Update("update sys_menu set del_flag=-1 where id=#{id}")
    void deleteMsg(Long id);

    @Insert("insert into sys_menu(name, parent_id, url, type, perms, order_num, create_by, create_time, del_flag) values (#{name},#{parentId},#{url},#{type},#{perms},#{orderNum},#{createBy},#{createTime},#{delFlag})")
    int addMsg(SysMenu sysMenu);

    @Update("update sys_menu set name=#{name}, url=#{url},last_update_time=#{lastUpdateTime},last_update_by=#{lastUpdateBy} where id=#{id}")
    void updateName(String name, String url, Long id, Date lastUpdateTime, String lastUpdateBy);


}
