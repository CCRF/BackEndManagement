package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yj
 * @Date    2022/8/4 18:40
 * @version: 1.0
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
    @PreAuthorize("hasAuthority('sys:setmeal:delete')")//
    public HttpResult deleteById(@RequestBody Integer id){
        return service.deleteById(id);
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
    @GetMapping("/selectByName/{name}")
    public HttpResult selectByNames(@PathVariable String name){
        List<SetMeal> meals = service.selectByNames(name);
        return HttpResult.ok(meals);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:setmeal:edit')")
    public HttpResult updateMeal(@RequestBody SetMeal setMeal){
        return service.updateMeal(setMeal);
    }


//    @GetMapping("/goods")
//    public HttpResult getAllGoods(){
//        List<Good> goods = service.getAllGoods();
//        return HttpResult.ok(goods);
//    }

    @GetMapping("/page/{page}/{size}")
    public HttpResult selectByPage(@PathVariable Integer page,@PathVariable Integer size){
        PageBean<SetMeal> bean = service.selectByPage(page, size);
        return HttpResult.ok(bean);
    }
}
