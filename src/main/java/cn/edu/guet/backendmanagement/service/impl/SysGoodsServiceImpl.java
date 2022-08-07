package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysCategory;
import cn.edu.guet.backendmanagement.bean.SysGoods;
import cn.edu.guet.backendmanagement.mapper.SysGoodsMapper;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
    public SysGoods selectById(long id) {
        return sysGoodsMapper.selectById(id);
    }

    @Override
    public List<SysGoods> selectByIsSale(int isSale) {
        return sysGoodsMapper.selectByIsSale(isSale);
    }

    @Override
    public List<SysGoods> selectByType(long typeId) {
        return sysGoodsMapper.selectByType(typeId);
    }

    @Override
    public List<SysGoods> selectByPrice(double price) {
        return sysGoodsMapper.selectByPrice(price);
    }

    @Override
    public List<SysGoods> selectByMsg(String msg) {
        msg = "%" + msg + "%";
        return sysGoodsMapper.selectByMsg(msg);
    }

    @Override
    public List<SysGoods> selectByAllMsg(String isSale, String typeId, String price, String msg) {
        if (isSale == "")
            isSale = null;
        if (typeId == "")
            typeId = null;
        if (price == "")
            price = null;
        msg = "%" + msg + "%";
        return sysGoodsMapper.selectByAllMsg(isSale, typeId, price, msg);
    }

    @Override
    public boolean insertGoods(ObjectNode json) {
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+json.get("id").toString()+ json.get("name").toString()+ json.get("price").toString()+ json.get("isSale").toString()+ json.get("picture").toString()+ json.get("remark").toString());
        sysGoodsMapper.insertGoods(json.get("id").toString(), json.get("name").toString(), json.get("price").toString(), json.get("isSale").toString(), json.get("picture").toString(), json.get("remark").toString());
        sysGoodsMapper.insertGC(json.get("id").toString(), json.get("id").toString(), json.get("type").toString());
        return true;
    }

    @Override
    public boolean updateGoods(SysGoods sysGoods) {
        System.out.println(sysGoods.toString());
        long id = sysGoods.getId();
        long type = sysGoods.getType().get(0).getId();
        sysGoodsMapper.updateGoodsById(id, sysGoods.getName(), sysGoods.getPrice(), sysGoods.getIsSale(), sysGoods.getPicture(), sysGoods.getRemark());
        sysGoodsMapper.updateGCByGId(id, type);
        return true;
    }

    @Override
    public boolean deleteGoodsById(long id) {
        sysGoodsMapper.deleteGCByGId(id);
        sysGoodsMapper.deleteGoodsById(id);
        return true;
    }

    @Override
    public List<SysCategory> findAllType() {
        return sysGoodsMapper.findAllType();
    }

    @Override
    public boolean deleteCategoryById(long id) {
        sysGoodsMapper.deleteGCByCId(id);
        sysGoodsMapper.deleteCategoryById(id);
        return true;
    }
}
