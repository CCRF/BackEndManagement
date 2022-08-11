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
    public HttpResult addCustomerIntegralByOpenId(String openid, int integral) {
        int i =  sysVoucherMapper.addCustomerIntegralByOpenId(openid,integral);
        return i>0 ? HttpResult.ok("用户积分增加成功") : HttpResult.error("用户积分增加失败");
    }

    @Override
    public HttpResult reduceCustomerIntegralByOpenId(String openid, int integral) {
        int i =  sysVoucherMapper.reduceCustomerIntegralByOpenId(openid,integral);
        return i>0 ? HttpResult.ok("用户积分减少成功") : HttpResult.error("用户积分减少失败");
    }

    @Override
    public HttpResult getCustomerIntegralByOpenId(String openid) {
        int i =  sysVoucherMapper.getCustomerIntegralByOpenId(openid);
        return i>0 ? HttpResult.ok(i) : HttpResult.error("获取用户积分失败");
    }

    @Override
    public HttpResult getLimitGoodsByVoucherId(String openId) {
        List<SysVoucher> limitGoodsOfVoucher = sysVoucherMapper.getLimitGoodsByVoucherId(openId);
        return HttpResult.ok(limitGoodsOfVoucher);
    }

    @Override
    public HttpResult getCustomerSignInStatus(String openId) {
        return HttpResult.ok(sysVoucherMapper.getCustomerSignInStatus(openId));
    }

    @Override
    public HttpResult updateCustomerSignInStatus(String openId, String signInStatus) {
        int i =  sysVoucherMapper.updateCustomerSignInStatus(openId,signInStatus);
        return i>0 ? HttpResult.ok("用户签到状态更新成功") : HttpResult.error("用户签到状态更新失败");
    }


}
