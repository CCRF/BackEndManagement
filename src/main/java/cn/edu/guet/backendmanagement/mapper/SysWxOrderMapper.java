package cn.edu.guet.backendmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author HJK
 * @date 2022/8/13 23:46
 * @Version 1.0
 */

@Mapper
public interface SysWxOrderMapper {

    @Update("UPDATE sys_order SET order_status =  #{state} WHERE id = #{id}")
    int moderOrderState(String id,int state);

}
