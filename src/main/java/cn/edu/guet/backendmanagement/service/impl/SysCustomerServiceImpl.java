package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import cn.edu.guet.backendmanagement.mapper.SysCustomerMapper;
import cn.edu.guet.backendmanagement.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysCustomerServiceImpl implements SysCustomerService {
    @Autowired
    private SysCustomerMapper scm;

    @Override
    public SysCustomer getCustomer(String openId) {
        return scm.getCustomer(openId);
    }

    @Override
    public int addCustomer(SysCustomer customer) {
        return scm.addCustomer(customer);
    }

    @Override
    public int updatePhoneNumber(String openId, String phoneNumber) {
        return scm.updatePhoneNumber(openId,phoneNumber);
    }
}
