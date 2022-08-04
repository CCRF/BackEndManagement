package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/4 18:40
 * @version: 1.0
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

    @Select("select * from sys_setmeal where name like CONCAT('%',#{name},'%')")
    List<SetMeal> selectByNames(String name);

    @Update("update sys_setmeal set name = #{name}, price = #{price}," +
            " contain = #{contain}, description = #{description}, sale = #{sale}, flavor = #{flavor}, picture = #{picture}" +
            "where id = #{id}")
    int updateMeal(SetMeal setMeal);

//    @Select("select * from sys_goods")
//    List<Good> getAllGoods();

    @Select("SELECT * FROM `sys_setmeal` LIMIT #{page} ,#{size}")
    List<SetMeal> selectByPage(Integer page, Integer size);

    @Select("select count(*) from sys_setmeal")
    Integer selectTotalCount();
}

//    private Integer id;
//    private String meal_name;
//    private Double price;
//    private String contain;
//    private String description;
//    public Integer sale;
//    private String flavor;
