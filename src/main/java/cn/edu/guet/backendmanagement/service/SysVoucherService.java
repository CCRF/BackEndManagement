package cn.edu.guet.backendmanagement.service;

import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;

import java.util.List;

/**
 * @Author: tjh
 * @Date: 2022/08/08/18:24
 * @Description:
 */
public interface SysVoucherService {

//    List<SysVoucher> getVoucherByOpenId (String openid);

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

    /**
     * 根据open_id为对应用户添加卡券
     * @param voucher
     * @return
     */
    HttpResult addCustomerCardVoucherByOpenId (SysVoucher voucher);

    /**
     * 根据voucher_id删除对对应卡券
     * @param voucherId
     * @return
     */
    HttpResult deleteCustomerCardVoucherByOpenId (String voucherId);


    /**
     * 根据voucher_id和goodId添加对应卡券的限定商品
     * @param voucherId
     * @param goodId
     * @return
     */
    HttpResult addCardVoucherLimitGoods (String voucherId,String goodId);

    /**
     * 根据open_id和dated获取刚刚加入的卡券id
     * @param openId
     * @param dated
     * @return
     */
    String getJustAddVoucherIdByOpenIdAndDated (String openId,String dated);


    /**
     * 根据open_id修改用户会员状态
     * @param openId
     * @param memberStatus
     * @param memberDated
     * @return
     */
    HttpResult updateCustomerMemberStatus (String openId,String memberStatus,String memberDated);

    /**
     * 将订单信息添加到订单表
     * @param order
     * @return
     */
    HttpResult addCustomerOrder (SysOrder order);

}
