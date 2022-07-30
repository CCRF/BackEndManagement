package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SetMeal;

import java.util.List;

/**
 * @Author yejian
 * @Date    2022/7/29 23:30
 * version: 1.0
 */
public interface SetMealService {
     List<SetMeal> selectAllMeal();

    boolean deleteById(Integer id);

    boolean insertMeal(SetMeal setMeal);

    SetMeal findById(Integer id);

    List<SetMeal> selectByNames(String name);

    boolean updateMeal(SetMeal setMeal);
}
