package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SetMeal;

import java.util.List;

/**
 * @Author yj
 * @Date    2022/7/30 19:00
 * @version: 1.0
 */
public interface SetMealService {
     List<SetMeal> selectAllMeal();

    boolean deleteById(Integer id);

    boolean insertMeal(SetMeal setMeal);

    SetMeal findById(Integer id);

    List<SetMeal> selectByNames(String name);

    boolean updateMeal(SetMeal setMeal);
}
