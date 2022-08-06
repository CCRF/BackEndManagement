package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysCustomer;

import java.util.List;

public interface SysCustomerService {
    //===========================查询================================
    SysCustomer getCustomer(String openId);

    List<SysCustomer> getAllCustomer();


    //===========================增、删、改================================
    int addCustomer(SysCustomer customer);

    int updatePhoneNumber(String openId, String phoneNumber);


    //===========================涉及业务操作================================
}
