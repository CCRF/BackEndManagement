package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SetMealMapper;
import cn.edu.guet.backendmanagement.service.SetMealService;
import cn.edu.guet.backendmanagement.util.LinuxLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @Author yj
 * @Date    2022/8/10 23:30
 * @version: 1.4
 */
@Service
public class SetMealServiceImpl implements SetMealService {
    @Autowired
    private SetMealMapper setMealMapper;
    @Autowired
    private LinuxLogin linuxLogin;



    @Override
    public List<SetMeal> selectAllMeal() {
        return setMealMapper.selectAllMeal();
    }

    @Override
    public HttpResult deleteById(Integer id,String imageUrl) {
        int i = setMealMapper.deleteById(id);
        //删除套餐图片
        File file = new File(imageUrl);
        if (file.isFile()){
            System.out.println("删除套餐图片");
            file.delete();
        }else {
            System.out.println("文件删除失败");
            return HttpResult.error("文件删除失败");
        }
        if (i>0){
            return HttpResult.ok("删除成功");
        }else {
            return HttpResult.error("删除失败");
        }
    }

    @Override
    public HttpResult insertMeal(SetMeal setMeal) {
        int i = setMealMapper.insertMeal(setMeal);
        System.out.println(i);
        return i>0 ? HttpResult.ok("插入成功") : HttpResult.error("插入失败");
    }

    public SetMeal findById(Integer id){
        return setMealMapper.findById(id);
    }

    @Override
    public PageBean<SetMeal> selectByNames(String name,Integer page,Integer size) {
        Integer begin = (page-1)*size;
        Integer count = setMealMapper.selectNameList(name);
        List<SetMeal> meals = setMealMapper.selectByNames(name, begin, size);
        PageBean<SetMeal> pageBean =new PageBean<>();
        pageBean.setRows(meals);
        pageBean.setTotalCount(count);
        return pageBean;

    }

    @Override
    public HttpResult updateMeal(SetMeal setMeal) {
        int i = setMealMapper.updateMeal(setMeal);
        return i>0 ? HttpResult.ok("更新成功") : HttpResult.error("更新失败");
    }

    @Override
    public PageBean<SetMeal> selectByPage(Integer page, Integer size) {
        Integer begin = (page-1)*size;
        Integer count = setMealMapper.selectTotalCount();
        List<SetMeal> meals = setMealMapper.selectByPage(begin, size);
        PageBean<SetMeal> pageBean =new PageBean<>();

        pageBean.setRows(meals);
        pageBean.setTotalCount(count);

        return pageBean;
    }

    @Override
    public String[] FindImageList() {
        System.out.println("方法被调用了");
        String path = "/usr/local/img/setmeal/";
        String[] list = linuxLogin.FindImageList(path);
        return list;
    }


    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        System.out.println("开始上传");
        String filePath = "/usr/local/img/setmeal/";
        String s = linuxLogin.uploadVideo(image,filePath);
        if (s!=null){
            System.out.println(s);
            System.out.println("上传成功");
        }else {
            System.out.println("上传失败");
        }
        return s;
    }


}
