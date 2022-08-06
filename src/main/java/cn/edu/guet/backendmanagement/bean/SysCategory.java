package cn.edu.guet.backendmanagement.bean;

import java.util.Objects;

/**
 * @author HHS
 * @date 2022/08/04 10:55
 */
public class SysCategory {
    private Long id;
    private String name;
    private String nickname;
    private String remark;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysCategory that = (SysCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(nickname, that.nickname) && Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, remark);
    }

    @Override
    public String toString() {
        return "SysCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
