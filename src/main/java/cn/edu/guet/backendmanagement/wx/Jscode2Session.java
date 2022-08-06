package cn.edu.guet.backendmanagement.wx;

import lombok.Data;

/**
 * @author : fitnessCode
 * @data : 2021/11/8 10:16
 * @description : 微信code返回信息
 */
@Data
public class Jscode2Session {

    /**
     * 微信用户的唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 用户在微信开放平台的唯一标识符。本字段在满足一定条件的情况下才返回。
     */
    private String unionid;
}

