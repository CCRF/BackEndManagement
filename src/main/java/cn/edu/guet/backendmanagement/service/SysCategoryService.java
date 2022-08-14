package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/12 15:10
 */
public interface SysCategoryService {
    List<SysCategory> findAllType();
    SysCategory selectCategoryById(long id);
    List<SysCategory> selectCategoryByAllMsg(String msg);
    boolean insertCategory(SysCategory sysCategory);
    boolean updateCategoryById(SysCategory sysCategory);
    boolean deleteCategoryById(long id) throws DataIntegrityViolationException;
}
