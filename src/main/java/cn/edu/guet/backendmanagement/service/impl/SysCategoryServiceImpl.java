package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.mapper.SysCategoryMapper;
import cn.edu.guet.backendmanagement.service.SysCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/12 15:14
 */
@Service
public class SysCategoryServiceImpl implements SysCategoryService {

    @Autowired
    private SysCategoryMapper sysCategoryMapper;

    @Override
    public List<SysCategory> findAllType() {
        return sysCategoryMapper.findAllType();
    }

    @Override
    public SysCategory selectCategoryById(long id) {
        return sysCategoryMapper.selectCategoryById(id);
    }

    @Override
    public List<SysCategory> selectCategoryByAllMsg(String msg) {
        msg = "%" + msg + "%";
        return sysCategoryMapper.selectCategoryByAllMsg(msg);
    }

    @Override
    public boolean insertCategory(SysCategory sysCategory) {
        sysCategoryMapper.insertCategory(sysCategory.getId(), sysCategory.getName(), sysCategory.getNickname(), sysCategory.getRemark());
        return true;
    }

    @Override
    public boolean updateCategoryById(SysCategory sysCategory) {
        sysCategoryMapper.updateCategoryById(sysCategory.getId(), sysCategory.getName(), sysCategory.getNickname(), sysCategory.getRemark());
        return true;
    }

    @Override
    public boolean deleteCategoryById(long id) throws DataIntegrityViolationException {
        sysCategoryMapper.deleteCategoryById(id);
        return true;
    }
}
