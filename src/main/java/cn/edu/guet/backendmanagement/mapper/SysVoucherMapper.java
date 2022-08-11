package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: tjh
 * @Date: 2022/08/07/19:53
 * @Description:
 */
@Mapper
public interface SysVoucherMapper {

    @Select("SELECT * FROM sys_voucher WHERE open_id = #{openid}")
    List<SysVoucher> getVoucherByOpenId (String openid);

    List<SysVoucher> getLimitGoodsByVoucherId (String openId);

    @Select("SELECT integral FROM sys_customer WHERE open_id = #{openid}")
    int getCustomerIntegralByOpenId (String openid);

    @Update("UPDATE sys_customer SET integral = integral + #{integral} WHERE open_id = #{openid}")
    int addCustomerIntegralByOpenId (String openid, int integral);

    @Update("UPDATE sys_customer SET integral = integral - #{integral} WHERE open_id = #{openid}")
    int reduceCustomerIntegralByOpenId (String openid, int integral);

    @Select("SELECT sign_in_status FROM sys_customer WHERE open_id=#{openId}")
    String getCustomerSignInStatus (String openId);

    @Update("UPDATE  sys_customer SET sign_in_status = #{signInStatus} WHERE open_id = #{openId}")
    int updateCustomerSignInStatus (String openId,String signInStatus);




}
