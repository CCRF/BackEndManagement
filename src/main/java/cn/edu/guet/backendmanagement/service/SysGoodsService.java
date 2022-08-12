package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysGoods;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author HHS
 * @date 2022/08/03 22:35
 */
public interface SysGoodsService {
    List<SysGoods> findAll();
    SysGoods selectById(long id);
    List<SysGoods> selectByAllMsg(String isSale, String typeId, String price, String msg);
    boolean insertGoods(ObjectNode json);
    boolean updateGoods(SysGoods sysGoods);
    boolean deleteGoodsById(long id);

    String uploadImage(MultipartFile image, String type) throws IOException;
}
