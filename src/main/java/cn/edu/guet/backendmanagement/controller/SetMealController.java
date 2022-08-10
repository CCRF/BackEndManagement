package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/8 20:10
 * @version: 1.3
 */
@RestController
@RequestMapping("/setMeal")
public class SetMealController {
    @Autowired
    private SetMealService service;


    @GetMapping
    @PreAuthorize("hasAuthority('sys:setmeal:view')")
    public HttpResult selectAllMeal(){
        List<SetMeal> meals = service.selectAllMeal();
        return HttpResult.ok(meals);
    };


    @PostMapping("/deleteById")
    @PreAuthorize("hasAuthority('sys:setmeal:delete')")
    public HttpResult deleteById(@RequestParam("id") Integer id, @RequestParam("imageUrl") String imageUrl){
//        System.out.println(id);
//        System.out.println(imageUrl);
        return service.deleteById(id,imageUrl);
    }

    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('sys:setmeal:add')")
    //如果具有该权限就可以访问这个
    public HttpResult insertMeal(@RequestBody SetMeal setMeal){
        return service.insertMeal(setMeal);
    }

    @GetMapping("/selectById/{id}")
    public SetMeal selectById(@PathVariable Integer id){
        return service.findById(id);
    }

    //
    @GetMapping("/selectByName/{name}/{page}/{size}")
    public HttpResult selectByNames(@PathVariable String name,@PathVariable Integer page,@PathVariable Integer size){
        PageBean<SetMeal> meals = service.selectByNames(name,page,size);
        return HttpResult.ok(meals);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:setmeal:edit')")
    public HttpResult updateMeal(@RequestBody SetMeal setMeal){
        return service.updateMeal(setMeal);
    }


    @GetMapping("/page/{page}/{size}")
    public HttpResult selectByPage(@PathVariable Integer page,@PathVariable Integer size){
        PageBean<SetMeal> bean = service.selectByPage(page, size);
        return HttpResult.ok(bean);
    }

    @PostMapping("/upload")
    public HttpResult uploadImage(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        try {
            String image = service.uploadImage(file);
            return HttpResult.ok(image);
        } catch (IOException e) {
            return HttpResult.error("文件上传失败");
        }
    }

    //获取文件列表
    @GetMapping("/image")
    public HttpResult FindImageList(){
        String[] list = service.FindImageList();
        return HttpResult.ok(list);
    }
}
