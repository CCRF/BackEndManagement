package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/8 20:10
 * @version: 1.3
 */
public interface SetMealService {
     List<SetMeal> selectAllMeal();

    HttpResult deleteById(Integer id);

    HttpResult insertMeal(SetMeal setMeal);

    SetMeal findById(Integer id);

    List<SetMeal> selectByNames(String name);

    HttpResult updateMeal(SetMeal setMeal);

    String uploadImage(MultipartFile image) throws IOException;

    PageBean<SetMeal> selectByPage(Integer page, Integer size);

    String [] FindImageList();

}
