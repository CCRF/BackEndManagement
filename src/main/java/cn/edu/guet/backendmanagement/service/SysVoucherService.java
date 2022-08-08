package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;

import java.util.List;

/**
 * @Author: tjh
 * @Date: 2022/08/08/18:24
 * @Description:
 */
public interface SysVoucherService {
    /**
     * 根据用户open_id获取该用户的卡券信息
     * @param openid
     * @return
     */
    List<SysVoucher> getVoucherByOpenId (String openid);

    /**
     * 根据用户openid获取该用户的积分
     * @param openid
     * @return
     */
    HttpResult getCustomerIntegralByOpenId (String openid, int integral);

}
