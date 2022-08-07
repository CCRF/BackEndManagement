package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.bean.SysGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:25
 */
@Mapper
public interface SysGoodsMapper {
    List<SysGoods> findAll();
    SysGoods selectById(long id);
    List<SysGoods> selectByIsSale(int isSale);
    List<SysGoods> selectByType(long typeId);
    List<SysGoods> selectByPrice(double price);
    List<SysGoods> selectByMsg(String msg);
    List<SysGoods> selectByAllMsg(@Param(value = "isSale") String isSale,@Param(value = "typeId") String typeId,@Param(value = "price") String price,@Param(value = "msg") String msg);
    boolean insertGoods(@Param(value = "id") String id, @Param(value = "name") String name, @Param(value = "price") String price, @Param(value = "isSale") String isSale, @Param(value = "picture") String picture, @Param(value = "remark") String remark);
    boolean insertGC(@Param(value = "id") String id, @Param(value = "id") String gid, @Param(value = "type") String type);
    boolean updateGoodsById(@Param(value = "id") long id, @Param(value = "name") String name, @Param(value = "price") double price, @Param(value = "isSale") int isSale, @Param(value = "picture") String picture, @Param(value = "remark") String remark);
    boolean updateGCByGId(@Param(value = "gid") long gid, @Param(value = "cid") long type);
    boolean deleteGoodsById(long id);
    boolean deleteGCByGId(long id);

    List<SysCategory> findAllType();
//    boolean insertCategory();
//    boolean updateCategoryById();
    boolean deleteCategoryById(long id);
    boolean deleteGCByCId(long id);
}
