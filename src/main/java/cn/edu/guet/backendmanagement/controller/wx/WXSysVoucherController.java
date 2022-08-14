package cn.edu.guet.backendmanagement.controller.wx;

import cn.edu.guet.backendmanagement.bean.SysOrder;
import cn.edu.guet.backendmanagement.bean.SysVoucher;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysVoucherService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: tjh
 * @Date: 2022/08/07/19:51
 * @Description:
 */
@RequestMapping("wx")
@RestController
public class WXSysVoucherController {

    @Autowired
    private SysVoucherService sysVoucherService;

//    @GetMapping("/getVoucher")
//    public List<SysVoucher> getVoucherByOpenId (String openId){
//        System.out.println("传回来的openId" + openId);
//        return sysVoucherService.getVoucherByOpenId(openId);
//    }

    @PostMapping("/addCustomerIntegral")
    public HttpResult addCustomerIntegralByOpenId (String openId, int integral){
        return sysVoucherService.addCustomerIntegralByOpenId(openId,integral);
    }

    @PostMapping("/reduceCustomerIntegral")
    public HttpResult reduceCustomerIntegralByOpenId (String openId, int integral){
        return sysVoucherService.reduceCustomerIntegralByOpenId(openId,integral);
    }

    @GetMapping("/getCustomerIntegral")
    public HttpResult getCustomerIntegralByOpenId (String openId){
        System.out.println("初始化积分，传回来的数据：" + openId);
        return sysVoucherService.getCustomerIntegralByOpenId(openId);
    }

    @GetMapping("/getLimitGoods")
    public HttpResult getLimitGoodsByVoucherId (String openId) {
        System.out.println("传回来的数据" + openId);
        return sysVoucherService.getLimitGoodsByVoucherId(openId);
    }

    @GetMapping("/getCustomerSignInStatus")
    public HttpResult getCustomerSignInStatus (String openId) {
        System.out.println("获取初始签到状态，传回来的数据" + openId);
        return sysVoucherService.getCustomerSignInStatus(openId);
    }

    @PostMapping("/updateCustomerSignInStatus")
    public HttpResult updateCustomerSignInStatus (@RequestBody String signInfo) {
        System.out.println(signInfo);
        String str = signInfo.replaceFirst(",",";");
        String [] s = str.split(";");
        String openId = s[0].split(":")[1];
        String s1 = s[1].split(":")[1];
        String signInStatus = s1.substring(1,s1.length() - 2);

        System.out.println("更新签到状态，传回来的数据" + openId + "-----" + signInStatus);
        return sysVoucherService.updateCustomerSignInStatus(openId,signInStatus);
    }

    @PostMapping("/addCustomerCardVoucher")
    public HttpResult addCustomerCardVoucherByOpenId (@RequestBody SysVoucher voucher) {
        System.out.println("addCustomerCardVoucher" + "------" + voucher.toString());
        return sysVoucherService.addCustomerCardVoucherByOpenId(voucher);
    }

    @PostMapping("/deleteCustomerCardVoucher")
    public HttpResult deleteCustomerCardVoucherByOpenId (String voucherId) {
        System.out.println("deleteCustomerCardVoucher啊啊啊啊啊啊啊" + voucherId);
        return sysVoucherService.deleteCustomerCardVoucherByOpenId(voucherId);
    }

    @PostMapping("/updateCustomerMemberStatus")
    public HttpResult updateCustomerMemberStatus (String openId,String memberStatus,String memberDated) {
        System.out.println(memberStatus + " updateCustomerMemberStatus嘿嘿 " + openId + "====" +  memberDated);
        return sysVoucherService.updateCustomerMemberStatus(openId,memberStatus,memberDated);
    }

    @PostMapping("/addCustomerOrder")
    public HttpResult addCustomerOrder (@RequestBody SysOrder order) {
        System.out.println("addCustomerOrder很好a" + order);
//        return sysVoucherService.addCustomerOrder(order);
        return null;
    }

}
