package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.bean.SysGoods;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:35
 */
public interface SysGoodsService {
    List<SysGoods> findAll();
    SysGoods selectById(long id);
    List<SysGoods> selectByIsSale(int isSale);
    List<SysGoods> selectByType(long typeId);
    List<SysGoods> selectByPrice(double price);
    List<SysGoods> selectByMsg(String msg);
    List<SysGoods> selectByAllMsg(String isSale, String typeId, String price, String msg);
    boolean insertGoods(ObjectNode json);
    boolean updateGoods(SysGoods sysGoods);
    boolean deleteGoodsById(long id);

    List<SysCategory> findAllType();

    boolean deleteCategoryById(long id);
}
