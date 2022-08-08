package cn.edu.guet.backendmanagement.bean;

import java.util.Objects;

/**
 * @Author: tjh
 * @Date: 2022/08/08/18:17
 * @Description:
 */
public class SysVoucher {
    // 卡券id
    private String voucherId;
    // 用户openId
    private String openId;
    // 卡券名称
    private String voucherName;
    // 卡券截止日期
    private String voucherDated;
    // 卡券图片地址
    private String voucherUrl;
    // 卡券类型
    private String voucherType;
    // 限定卡券使用商品
    private String voucherLimit;

    public SysVoucher (){

    }

    public SysVoucher(String voucherId, String openId, String voucherName, String voucherDated,
                      String voucherUrl, String voucherType, String voucherLimit) {
        this.voucherId = voucherId;
        this.openId = openId;
        this.voucherName = voucherName;
        this.voucherDated = voucherDated;
        this.voucherUrl = voucherUrl;
        this.voucherType = voucherType;
        this.voucherLimit = voucherLimit;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public String getVoucherDated() {
        return voucherDated;
    }

    public void setVoucherDated(String voucherDated) {
        this.voucherDated = voucherDated;
    }

    public String getVoucherUrl() {
        return voucherUrl;
    }

    public void setVoucherUrl(String voucherUrl) {
        this.voucherUrl = voucherUrl;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getVoucherLimit() {
        return voucherLimit;
    }

    public void setVoucherLimit(String voucherLimit) {
        this.voucherLimit = voucherLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysVoucher that = (SysVoucher) o;
        return Objects.equals(voucherId, that.voucherId) && Objects.equals(openId, that.openId) && Objects.equals(voucherName, that.voucherName) && Objects.equals(voucherDated, that.voucherDated) && Objects.equals(voucherUrl, that.voucherUrl) && Objects.equals(voucherType, that.voucherType) && Objects.equals(voucherLimit, that.voucherLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, openId, voucherName, voucherDated, voucherUrl, voucherType, voucherLimit);
    }

    @Override
    public String toString() {
        return "SysVoucher{" +
                "voucherId='" + voucherId + '\'' +
                ", openId='" + openId + '\'' +
                ", voucherName='" + voucherName + '\'' +
                ", voucherDated='" + voucherDated + '\'' +
                ", voucherUrl='" + voucherUrl + '\'' +
                ", voucherType='" + voucherType + '\'' +
                ", voucherLimit='" + voucherLimit + '\'' +
                '}';
    }
}
