package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysGoods;
import cn.edu.guet.backendmanagement.mapper.SysGoodsCategoryMapper;
import cn.edu.guet.backendmanagement.mapper.SysGoodsMapper;
import cn.edu.guet.backendmanagement.service.SysGoodsService;
import cn.edu.guet.backendmanagement.util.LinuxLogin;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:36
 */
@Service
public class SysGoodsServiceImpl implements SysGoodsService {

    @Autowired
    private SysGoodsMapper sysGoodsMapper;
    @Autowired
    private SysGoodsCategoryMapper sysGoodsCategoryMapper;
    @Autowired
    private LinuxLogin linuxLogin;

    @Override
    public List<SysGoods> findAll() {
        return sysGoodsMapper.findAll();
    }

    @Override
    public SysGoods selectById(long id) {
        return sysGoodsMapper.selectById(id);
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
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean insertGoods(ObjectNode json) {
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+json.get("id").toString()+ json.get("name").toString()+ json.get("price").toString()+ json.get("isSale").toString()+ json.get("picture").toString()+ json.get("remark").toString());
        sysGoodsMapper.insertGoods(json.get("id").toString(), json.get("name").toString(), json.get("price").toString(), json.get("isSale").toString(), json.get("picture").toString(), json.get("remark").toString());
        sysGoodsCategoryMapper.insertGC(json.get("id").toString(), json.get("id").toString(), json.get("type").toString());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean updateGoods(SysGoods sysGoods) {
        System.out.println(sysGoods.toString());
        long id = sysGoods.getId();
        long type = sysGoods.getType().get(0).getId();
        sysGoodsMapper.updateGoodsById(id, sysGoods.getName(), sysGoods.getPrice(), sysGoods.getIsSale(), sysGoods.getPicture(), sysGoods.getRemark());
        sysGoodsCategoryMapper.updateGCByGId(id, type);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public boolean deleteGoodsById(long id) {
        sysGoodsCategoryMapper.deleteGCByGId(id);
        sysGoodsMapper.deleteGoodsById(id);
        return true;
    }

    @Override
    public String uploadImage(MultipartFile image, String type) throws IOException {
        System.out.println("开始上传" + type);
        String filePath = "user/local/img/" + type + "/";
        String s = linuxLogin.uploadVideo(image, filePath);
        if (s != null){
            System.out.println(s);
            System.out.println("上传成功");
        }
        else {
            System.out.println("上传失败");
        }
        return s;
    }
}
