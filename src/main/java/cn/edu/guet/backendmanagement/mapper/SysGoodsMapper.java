package cn.edu.guet.backendmanagement.mapper;

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
}
