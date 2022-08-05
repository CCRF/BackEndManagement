package cn.edu.guet.backendmanagement.controller;

import cn.edu.guet.backendmanagement.bean.SysCustomer;
import cn.edu.guet.backendmanagement.http.HttpResult;
import cn.edu.guet.backendmanagement.service.SysCustomerService;
import cn.edu.guet.backendmanagement.service.SysOrderService;
import cn.edu.guet.backendmanagement.util.WeChatUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysCustomerController {

    @Autowired
    private SysCustomerService scs;

    // RequestBody接收JSON对象
    @PostMapping("/wx/login")
    public HttpResult user_login(@RequestBody SysCustomer customer){
//    public HttpResult user_login(@RequestParam(value = "code", required = false) String code,
//                                 @RequestParam(value = "rawData", required = false) String rawData,
//                                 @RequestParam(value = "signature", required = false) String signature) {
        System.out.println("wx/login");

        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(customer.getRawData());
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        JSONObject SessionKeyOpenId = WeChatUtil.getSessionKeyOrOpenId(customer.getCode());
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");
        System.out.println("openid = " + openid);
        System.out.println("sessionKey = " + sessionKey);

        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
//        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
//        if (!signature.equals(signature2)) {
//            System.out.println("1111");
//            return HttpResult.error("签名校验失败");
//        }

        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；
//        LambdaQueryWrapper<WeChatUser> lqw = Wrappers.lambdaQuery();
//        lqw.eq(WeChatUser::getOpenId, openid);
//        WeChatUser user = userService.getOne(lqw);
//        System.out.println("lqw " + lqw);
//        WeChatUser user = null;

        SysCustomer user = scs.getCustomer(openid);
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickName");
            String avatarUrl = rawDataJson.getString("avatarUrl");
            user = new SysCustomer();
            user.setOpenId(openid);
            user.setAvatar(avatarUrl);
            user.setNickName(nickName);
            scs.addCustomer(user);
        }
        System.out.println("登录成功：" + user);
        return HttpResult.ok(user);
    }
}