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
     * 根据用户openid增加该用户的积分
     * @param openid
     * @return
     */
    HttpResult addCustomerIntegralByOpenId (String openid, int integral);

    /**
     * 根据用户openid减少该用户的积分
     * @param openid
     * @return
     */
    HttpResult reduceCustomerIntegralByOpenId (String openid, int integral);

    /**
     * 根据用户openid获取该用户的积分
     * @param openid
     * @return
     */
    HttpResult getCustomerIntegralByOpenId (String openid);


    /**
     * 根据open_id 获取所有卡券和对应的限定商品
     * @param openId
     * @return
     */
    HttpResult getLimitGoodsByVoucherId (String openId);

    /**
     * 根据open_id获取用户签到状态
     * @param openId
     * @return
     */
    HttpResult getCustomerSignInStatus (String openId);

    /**
     * 根据open_id更新对应用户的签到状态
     * @param openId
     * @param signInStatus
     * @return
     */
    HttpResult updateCustomerSignInStatus (String openId,String signInStatus);

}
