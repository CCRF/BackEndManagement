package cn.edu.guet.backendmanagement.mapper;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCustomerMapper {
    //===========================查询================================
    SysCustomer getCustomer(String openId);

    List<SysCustomer> getAllCustomer();


    //===========================增、删、改================================
    int addCustomer(SysCustomer customer);

    int updatePhoneNumber(String openId, String phoneNumber);
}
