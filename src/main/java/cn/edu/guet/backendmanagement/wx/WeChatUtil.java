package cn.edu.guet.backendmanagement.wx;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class WeChatUtil {
    // code从前端传入
    public static JSONObject getSessionKeyOrOpenId(String code) {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> requestUrlParam = new HashMap<>();
        // https://mp.weixin.qq.com/wxopen/devprofile?action=get_profile&token=164113089&lang=zh_CN
        //小程序appId
        requestUrlParam.put("appid", WXConstant.APPID);
        //小程序secret
        requestUrlParam.put("secret", WXConstant.SECRET);
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpClientUtil.doPost(requestUrl, requestUrlParam));
        return jsonObject;
    }
//
//
//
//        private static final String url = "https://api.weixin.qq.com/sns/jscode2session";
//
//        public static Jscode2Session getCode(String appId, String appSecret, String code) {
//            //HTTP请求工具类
//            RestTemplate restTemplate = new RestTemplate();
//            //微信返回内容
//            Jscode2Session jscode2Session = null;
//            String str = restTemplate.getForObject(url + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code", String.class);
//            jscode2Session = JSONObject.parseObject(str, new TypeReference<Jscode2Session>() {
//            });
//            return jscode2Session;
//        }

        public static PhoneNumberDto getPhone(String iv, String encryptedData, String sessionKey) {
            String s = null;
            try {
                //解密微信绑定手机号
                s = AES.decryptData(encryptedData, sessionKey, iv);
            } catch (Exception e) {
                e.printStackTrace();
            }
            PhoneNumberDto phoneNumberDto = JSON.parseObject(s, PhoneNumberDto.class);
            return phoneNumberDto;
        }



}

