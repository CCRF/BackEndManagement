package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SetMeal;
import cn.edu.guet.backendmanagement.mapper.SetMealMapper;
import cn.edu.guet.backendmanagement.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author yj
 * @Date    2022/7/30 19:00
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
    public boolean deleteById(Integer id) {
        setMealMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean insertMeal(SetMeal setMeal) {
        setMealMapper.insertMeal(setMeal);
        return false;
    }

    public SetMeal findById(Integer id){
        return setMealMapper.findById(id);
    }

    @Override
    public List<SetMeal> selectByNames(String name) {
        return setMealMapper.selectByNames(name);
    }

    @Override
    public boolean updateMeal(SetMeal setMeal) {
        setMealMapper.updateMeal(setMeal);
        return true;
    }
}
