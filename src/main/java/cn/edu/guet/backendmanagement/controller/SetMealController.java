package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yejian
 * @Date    2022/7/29 23:30
 * version: 1.0
 */
@RestController
@RequestMapping("/setMeal")
public class SetMealController {
    @Autowired
    private SetMealService service;


    @GetMapping
    @PreAuthorize("hasAuthority('sys:setmeal:view')")
    public List<SetMeal> selectAllMeal(){
        return service.selectAllMeal();
    };


    @PostMapping("/deleteById")
    @PreAuthorize("hasAuthority('sys:setmeal:delete')")//
    public boolean deleteById(@RequestBody Integer id){
//        System.out.println("方法被调用了"+id);
        return service.deleteById(id);
    }

    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('sys:setmeal:add')")
    //如果具有该权限就可以访问这个
    public boolean insertMeal(@RequestBody SetMeal setMeal){
        System.out.println(setMeal);
        return service.insertMeal(setMeal);
    }

    @GetMapping("/selectById/{id}")
    public SetMeal selectById(@PathVariable Integer id){
        return service.findById(id);
    }

    //
    @GetMapping("/selectByName/{name}")
    public List<SetMeal> selectByNames(@PathVariable String name){
        return service.selectByNames(name);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:setmeal:edit')")
    public boolean updateMeal(@RequestBody SetMeal setMeal){
        return service.updateMeal(setMeal);
    }
}
