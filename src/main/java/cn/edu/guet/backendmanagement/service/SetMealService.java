package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;

import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/4 18:40
 * @version: 1.0
 */
public interface SetMealService {
     List<SetMeal> selectAllMeal();

    HttpResult deleteById(Integer id);

    HttpResult insertMeal(SetMeal setMeal);

    SetMeal findById(Integer id);

    List<SetMeal> selectByNames(String name);

    HttpResult updateMeal(SetMeal setMeal);

//    List<Good> getAllGoods();

    PageBean<SetMeal> selectByPage(Integer page, Integer size);
}
