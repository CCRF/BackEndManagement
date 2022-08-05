package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysCustomer;

public interface SysCustomerService {
    SysCustomer getCustomer(String openId);
    int addCustomer(SysCustomer customer);
}
