package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysCustomerMapper {
    SysCustomer getCustomer(String openId);

    int addCustomer(SysCustomer customer);

    int updatePhoneNumber(String openId, String phoneNumber);
}
