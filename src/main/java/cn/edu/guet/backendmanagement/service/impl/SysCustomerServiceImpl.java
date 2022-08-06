package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import cn.edu.guet.backendmanagement.mapper.SysCustomerMapper;
import cn.edu.guet.backendmanagement.service.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCustomerServiceImpl implements SysCustomerService {
    @Autowired
    private SysCustomerMapper scm;

    //===========================查询================================
    @Override
    public SysCustomer getCustomer(String openId) {
        return scm.getCustomer(openId);
    }

    @Override
    public List<SysCustomer> getAllCustomer() {
        return scm.getAllCustomer();
    }


    //===========================增、删、改================================
    @Override
    public int updatePhoneNumber(String openId, String phoneNumber) {
        return scm.updatePhoneNumber(openId,phoneNumber);
    }

    @Override
    public int addCustomer(SysCustomer customer) {
        return scm.addCustomer(customer);
    }


    //===========================涉及业务操作================================

}
