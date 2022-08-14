package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/12 14:52
 */
@Mapper
public interface SysCategoryMapper {
    List<SysCategory> findAllType();
    SysCategory selectCategoryById(long id);
    List<SysCategory> selectCategoryByAllMsg(String msg);
    boolean insertCategory(@Param(value = "id") long id, @Param(value = "name") String name, @Param(value = "nickname") String nickname, @Param(value = "remark") String remark);
    boolean updateCategoryById(@Param(value = "id") long id, @Param(value = "name") String name, @Param(value = "nickname") String nickname, @Param(value = "remark") String remark);
    boolean deleteCategoryById(long id);
}
