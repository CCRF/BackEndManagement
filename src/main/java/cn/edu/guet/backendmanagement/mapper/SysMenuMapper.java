package cn.edu.guet.backendmanagement.mapper;

import java.util.List;

import cn.edu.guet.backendmanagement.bean.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Liwei
 * @Date 2021-08-13 17:50
 */
@Mapper
public interface SysMenuMapper {
    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param(value = "userName") String userName);

    @Select("select * from sys_menu WHERE del_flag!=-1 limit #{begin},#{size} ")
    List<SysMenu> selectByPage(int begin, int size);

    @Select("select count(*) from sys_menu WHERE del_flag!=-1")
    int selectTotalCount();
}
