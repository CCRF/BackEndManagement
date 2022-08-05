package cn.edu.guet.backendmanagement.wx;


import lombok.Data;

/**
 * @author : fitnessCode
 * @data : 2021/11/8 10:07
 * @description : 解析微信手机号
 */
@Data
public class PhoneNumberDto {

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;

    /**
     * 区号
     */
    private String countryCode;

    /**
     * appId时间戳（验证使用）
     */
    private String watermark;
}

