package com.OOZone.entity;
import java.util.List;
/**
 * 用户实体
 */
public class User {
    private Integer id; // 主键

    private String userName; // 账号
    private String password; // 密码
    private String roleName; //用户名
    private String sex;//性别
    private String introduction;//个人简介
    private String phone;//电话号码
    private List<Essay> favorites;//个人收藏

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Essay> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Essay> favorites) {
        this.favorites = favorites;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
