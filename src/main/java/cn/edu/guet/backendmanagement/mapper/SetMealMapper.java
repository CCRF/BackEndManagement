package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author yejian
 * @Date    2022/7/29 23:30
 * version: 1.0
 */
@Mapper
public interface SetMealMapper {
    @Select("select * from sys_setmeal")
     List<SetMeal> selectAllMeal();

    @Delete("delete from sys_setmeal where id = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO sys_setmeal(meal_name,price,contain,description,sale,flavor)" +
            " values(#{meal_name},#{price},#{contain},#{description},#{sale},#{flavor})")
    void insertMeal(SetMeal setMeal);

//    INSERT INTO sys_setmeal(meal_name,price,contain,description,sale,flavor)
//    VALUES('3',3.0,'3','3',35,'3')


    @Select("select * from sys_setmeal where id = #{id}")
    SetMeal findById(Integer id);

    @Select("select * from sys_setmeal where meal_name like CONCAT('%',#{name},'%')")
    List<SetMeal> selectByNames(String name);

    @Update("update sys_setmeal set meal_name = #{meal_name}, price = #{price}," +
            " contain = #{contain}, description = #{description}, sale = #{sale}, flavor = #{flavor}" +
            "where id = #{id}")
    void updateMeal(SetMeal setMeal);
}

//    private Integer id;
//    private String meal_name;
//    private Double price;
//    private String contain;
//    private String description;
//    public Integer sale;
//    private String flavor;
