package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysGoods;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:35
 */
public interface SysGoodsService {
    List<SysGoods> findAll();
}
