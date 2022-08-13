package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

/**
 * @author HHS
 * @date 2022/08/12 15:22
 */
@RestController
@RequestMapping("category")
public class SysCategoryController {

    @Autowired
    private SysCategoryService sysCategoryService;

    @GetMapping("/findAllType")
    public HttpResult findAllType() {
//        System.out.println(sysCategoryService.findAllType());
        return HttpResult.ok(sysCategoryService.findAllType());
    }

    @GetMapping("/selectCategoryById")
    public HttpResult selectCategoryById(long id) {
//        System.out.println(sysCategoryService.selectCategoryById(id));
        return HttpResult.ok(sysCategoryService.selectCategoryById(id));
    }

    @GetMapping("/selectCategoryByAllMsg")
    public HttpResult selectCategoryByAllMsg(@RequestParam String msg) {
//        System.out.println(sysCategoryService.selectCategoryByAllMsg(msg));
        return HttpResult.ok(sysCategoryService.selectCategoryByAllMsg(msg));
    }

    @PostMapping("/insertCategory")
    public HttpResult insertCategory(@RequestBody SysCategory sysCategory) {
//        System.out.println(id);
        return HttpResult.ok(sysCategoryService.insertCategory(sysCategory));
    }

    @PostMapping("/updateCategory")
    public HttpResult updateCategory(@RequestBody SysCategory sysCategory) {
//        System.out.println(id);
        return HttpResult.ok(sysCategoryService.updateCategoryById(sysCategory));
    }

    @PostMapping("/deleteCategory")
    public HttpResult deleteCategory(@RequestBody long id) {
        System.out.println("dC:"+id);
        try {
            HttpResult result = HttpResult.ok(sysCategoryService.deleteCategoryById(id));
            return result;
        } catch (DataIntegrityViolationException e) {
            return HttpResult.error("数据删除失败");
        }
    }

}
