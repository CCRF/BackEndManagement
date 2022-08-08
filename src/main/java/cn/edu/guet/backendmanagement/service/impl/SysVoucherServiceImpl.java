package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SysVoucherMapper;
import cn.edu.guet.backendmanagement.service.SysVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tjh
 * @Date: 2022/08/08/18:26
 * @Description:
 */
@Service
public class SysVoucherServiceImpl implements SysVoucherService {

    @Autowired
    private SysVoucherMapper sysVoucherMapper;

    @Override
    public List<SysVoucher> getVoucherByOpenId(String openid) {
        return sysVoucherMapper.getVoucherByOpenId(openid);
    }

    @Override
    public HttpResult getCustomerIntegralByOpenId(String openid, int integral) {
        int i =  sysVoucherMapper.getCustomerIntegralByOpenId(openid,integral);
        return i>0 ? HttpResult.ok("用户积分更新成功") : HttpResult.error("用户积分更新失败");
    }
}
