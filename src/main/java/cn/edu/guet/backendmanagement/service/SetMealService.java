package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/11 19：22
 * @version: 1.5
 */
public interface SetMealService {
     List<SetMeal> selectAllMeal();

    HttpResult deleteById(Integer id,String imageUrl);

    HttpResult insertMeal(SetMeal setMeal);

    SetMeal findById(Integer id);

    PageBean<SetMeal> selectByNames(String name,Integer page,Integer size);

    HttpResult updateMeal(SetMeal setMeal);

    String uploadImage(MultipartFile image) throws IOException;

    PageBean<SetMeal> selectByPage(Integer page, Integer size);

    String [] FindImageList();

    boolean deleteFile(String file);

}
