package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.Order;
import cn.edu.guet.backendmanagement.bean.SysMenu;
import cn.edu.guet.backendmanagement.bean.SysRole;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Author:chenchaosheng
 * Date: 2022/7/30 10:17
 * Version: 1.0
 */
@Mapper
public interface SysOrderMapper {
    @Select("SELECT * FROM sys_order where order_status=0")
    List<Order> getCurrentOrder();
    @Select("SELECT * FROM sys_order where order_status in(-1,1)")
    List<Order> getHistoryOrder();
    @Update("UPDATE sys_order SET start_time=#{startTime},list=#{list},amount=#{amount},order_status=#{orderStatus},message=#{message},customer_id=#{customerId} WHERE id=#{id}")
    Integer modifyOrder(Order order);

    Integer deleteOrder(@Param("orderList")List<BigInteger> orderList);
    @Insert("INSERT INTO sys_order(start_time,list,amount,order_status,message,customer_id) VALUES(#{startTime},#{list},#{amount},#{orderStatus},#{message},#{customerId})")
    Integer insert(Order order);
    @Select(
       "SELECT sm.* from sys_menu sm join sys_role_menu srm on srm.menu_id = sm.id join sys_role sr on sr.id = srm.role_id join sys_user_role sur on sur.role_id = sr.id join sys_user su on su.id = sur.user_id where su.`name` = #{username}"
    )
    List<SysMenu> queryMenuNameByUserName(@Param("username") String username);


}
