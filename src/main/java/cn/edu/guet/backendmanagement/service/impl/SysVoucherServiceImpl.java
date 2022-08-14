package cn.edu.guet.backendmanagement.service.impl;

import cn.edu.guet.backendmanagement.bean.SysGoods;
import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.mapper.SysVoucherMapper;
import cn.edu.guet.backendmanagement.service.SysVoucherService;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
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

//    @Override
//    public List<SysVoucher> getVoucherByOpenId(String openid) {
//        return sysVoucherMapper.getVoucherByOpenId(openid);
//    }

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
//        for (SysVoucher voucher : limitGoodsOfVoucher) {
//            String rai = voucher.getVoucherRai();
//            for (SysGoods sysGoods : voucher.getVoucherLimit()) {
//                if ("a".equals(rai)) {
//
//                } else if ("b".equals(rai)) {
//
//                } else if ("c".equals(rai)) {
//
//                }
//                else if ("d".equals(rai)) {
//
//                }
//                else if ("e".equals(rai)) {
//
//                }
//                else if ("f".equals(rai)) {
//
//                } else {
//
//                }
//            }
//        }
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

    @Override
    public HttpResult addCustomerCardVoucherByOpenId(SysVoucher voucher) {
        int i =  sysVoucherMapper.addCustomerCardVoucherByOpenId(voucher);
        if (i > 0) {
            String voucherId = getJustAddVoucherIdByOpenIdAndDated(voucher.getOpenId(),voucher.getVoucherDated());
            for (SysGoods sysGoods : voucher.getVoucherLimit()) {
                if (sysGoods.getId() != null){
                    addCardVoucherLimitGoods(voucherId,String.valueOf(sysGoods.getId()));
                } else {
                    System.out.println("卡券限定商品添加出错！");
                    return null;
                }
            }
            return HttpResult.ok("用户卡券添加成功");
        } else return HttpResult.error("用户卡券添加失败");
    }

    @Override
    public HttpResult deleteCustomerCardVoucherByOpenId(String voucherId) {
        int i =  sysVoucherMapper.deleteCustomerCardVoucherByOpenId(voucherId);
        return i>0 ? HttpResult.ok("用户卡券删除成功") : HttpResult.error("用户卡券删除失败");
    }

    @Override
    public HttpResult addCardVoucherLimitGoods(String voucherId,String goodId) {
        int i =  sysVoucherMapper.addCardVoucherLimitGoods(voucherId,goodId);
        return i>0 ? HttpResult.ok("用户卡券限定商品添加成功") : HttpResult.error("用户卡券限定商品添加失败");
    }

    @Override
    public String getJustAddVoucherIdByOpenIdAndDated(String openId,String dated) {
        return sysVoucherMapper.getJustAddVoucherIdByOpenIdAndDated(openId,dated);
    }

    @Override
    public HttpResult updateCustomerMemberStatus(String openId,String memberStatus,String memberDated) {
        int i =  sysVoucherMapper.updateCustomerMemberStatus(openId,memberStatus,memberDated);
        return i>0 ? HttpResult.ok("用户会员状态更新成功") : HttpResult.error("用户会员状态更新失败");
    }

    @Override
    public HttpResult addCustomerOrder(SysOrder order) {
        int i =  sysVoucherMapper.addCustomerOrder(order);
        return i>0 ? HttpResult.ok("用户订单添加成功") : HttpResult.error("用户订单添加失败");
    }

}
