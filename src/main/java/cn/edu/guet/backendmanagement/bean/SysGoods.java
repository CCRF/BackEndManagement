package cn.edu.guet.backendmanagement.bean;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @author HHS
 * @date 2022/08/03 22:13
 */
@Data
public class SysGoods {
    private Long id;
    private List<SysCategory> type;
    private String name;
    private double price;
    private int isSale;
    private String remark;
    private String picture;

    public SysGoods (Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SysCategory> getType() {
        return type;
    }

    public void setType(List<SysCategory> type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysGoods sysGoods = (SysGoods) o;
        return Double.compare(sysGoods.price, price) == 0 && isSale == sysGoods.isSale && Objects.equals(id, sysGoods.id) && Objects.equals(type, sysGoods.type) && Objects.equals(name, sysGoods.name) && Objects.equals(remark, sysGoods.remark) && Objects.equals(picture, sysGoods.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, price, isSale, remark, picture);
    }

    @Override
    public String toString() {
        return "SysGoods{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isSale=" + isSale +
                ", remark='" + remark + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
