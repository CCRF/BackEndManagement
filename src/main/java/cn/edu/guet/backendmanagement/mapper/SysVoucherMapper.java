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

    @Update("UPDATE sys_customer SET integral = integral + #{integral} WHERE open_id = #{openid}")
    int getCustomerIntegralByOpenId (String openid, int integral);
}
