package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.bean.SysGoods;
import cn.edu.guet.backendmanagement.mapper.SysGoodsMapper;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:36
 */
@Service
public class SysGoodsServiceImpl implements SysGoodsService {

    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    @Override
    public List<SysGoods> findAll() {
        return sysGoodsMapper.findAll();
    }

    @Override
    public List<SysGoods> selectByIsSale(int isSale) {
        return sysGoodsMapper.selectByIsSale(isSale);
    }

    @Override
    public List<SysGoods> selectByType(String typeName) {
        return sysGoodsMapper.selectByType(typeName);
    }

    @Override
    public List<SysGoods> selectByPrice(double price) {
        return sysGoodsMapper.selectByPrice(price);
    }

    @Override
    public List<SysGoods> selectByMsg(String msg) {
        return sysGoodsMapper.selectByMsg(msg);
    }

    @Override
    public List<SysCategory> findAllType() {
        return sysGoodsMapper.findAllType();
    }
}
