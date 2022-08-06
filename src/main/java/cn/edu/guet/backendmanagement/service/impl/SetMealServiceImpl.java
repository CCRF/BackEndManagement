package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.PageBean;
import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SetMealMapper;
import cn.edu.guet.backendmanagement.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author yj
 * @Date    2022/8/4 18:40
 * @version: 1.0
 */
@Service
public class SetMealServiceImpl implements SetMealService {
    @Autowired
    private SetMealMapper setMealMapper;

    @Override
    public List<SetMeal> selectAllMeal() {
        return setMealMapper.selectAllMeal();
    }

    @Override
    public HttpResult deleteById(Integer id) {
        int i = setMealMapper.deleteById(id);
        if (i>0){
            return HttpResult.ok("删除成功");
        }else {
            return HttpResult.error("删除失败");
        }
    }

    @Override
    public HttpResult insertMeal(SetMeal setMeal) {
        int i = setMealMapper.insertMeal(setMeal);
//        if (i>0){
//            return HttpResult.ok("插入成功");
//        }else {
//            return HttpResult.error("插入失败了");
//        }
        return i>0 ? HttpResult.ok("更新成功") : HttpResult.error("更新失败");
    }

    public SetMeal findById(Integer id){
        return setMealMapper.findById(id);
    }

    @Override
    public List<SetMeal> selectByNames(String name) {
        return setMealMapper.selectByNames(name);
    }

    @Override
    public HttpResult updateMeal(SetMeal setMeal) {
        int i = setMealMapper.updateMeal(setMeal);
        return i>0 ? HttpResult.ok("更新成功") : HttpResult.error("更新失败");
    }


//    public List<Good> getAllGoods() {
//        return setMealMapper.getAllGoods();
//    }

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
}
