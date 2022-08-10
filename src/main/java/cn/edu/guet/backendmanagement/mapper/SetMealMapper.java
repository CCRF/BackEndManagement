package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/10 23:30
 * @version: 1.4
 */
@Mapper
public interface SetMealMapper {
    @Select("select * from sys_setmeal")
     List<SetMeal> selectAllMeal();

    @Delete("delete from sys_setmeal where id = #{id}")
    int deleteById(Integer id);

    @Insert("INSERT INTO sys_setmeal(name,price,contain,description,sale,flavor,picture)" +
            " values(#{name},#{price},#{contain},#{description},#{sale},#{flavor},#{picture})")
    int insertMeal(SetMeal setMeal);

    @Select("select * from sys_setmeal where id = #{id}")
    SetMeal findById(Integer id);

    @Select("select * from sys_setmeal where name like CONCAT('%',#{name},'%')LIMIT #{page},#{size}")
    List<SetMeal> selectByNames(String name,Integer page,Integer size);

    @Select("select count(*) from sys_setmeal where name like CONCAT('%','香','%')")
    Integer selectNameList(String name);


    @Update("update sys_setmeal set name = #{name}, price = #{price}," +
            " contain = #{contain}, description = #{description}, sale = #{sale}, flavor = #{flavor}, picture = #{picture}" +
            "where id = #{id}")
    int updateMeal(SetMeal setMeal);


    @Select("SELECT * FROM `sys_setmeal` LIMIT #{page} ,#{size}")
    List<SetMeal> selectByPage(Integer page, Integer size);

    @Select("select count(*) from sys_setmeal")
    Integer selectTotalCount();
}


