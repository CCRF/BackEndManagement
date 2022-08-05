package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.bean.SysGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:25
 */
@Mapper
public interface SysGoodsMapper {
    List<SysGoods> findAll();
    List<SysGoods> selectByIsSale(int isSale);
    List<SysGoods> selectByType(String typeName);
    List<SysGoods> selectByPrice(double price);
    List<SysGoods> selectByMsg(String msg);
//    boolean insertGoods();
//    boolean insertCategory();
//    boolean updateGoodsById();
//    boolean updateCategoryById();
//    boolean deleteGoodsById(long id);
//    boolean deleteCategoryById(long id);

    List<SysCategory> findAllType();
}
