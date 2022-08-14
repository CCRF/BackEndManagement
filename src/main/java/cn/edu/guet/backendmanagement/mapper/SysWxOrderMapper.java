package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author HJK
 * @date 2022/8/13 23:46
 * @Version 1.0
 */

@Mapper
public interface SysWxOrderMapper {

    @Select("SELECT * FROM sys_order where order_status=0 ORDER BY start_time DESC ")
    List<SysOrder> getCurrentOrder();

    @Select("SELECT * FROM sys_order where order_status in(-1,1) ORDER By start_time DESC ")
    List<SysOrder> getHistoryOrder();

    @Update("UPDATE sys_order SET order_status =  #{state} WHERE id = #{id}")
    int moderOrderState(String id,int state);

}
