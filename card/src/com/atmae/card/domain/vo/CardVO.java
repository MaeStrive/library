package com.atmae.card.domain.vo;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 19:07
 * @Description:
 */
public class CardVO {
    private Long id;
    private String name;
    private String gender;
    private String account;
    private String password;
    private String email;
    //名片所属人
    private String sysName;

    public CardVO(Long id, String name, String gender, String account, String password, String email, String sysName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.password = password;
        this.email = email;
        this.sysName=sysName;
    }

    public CardVO() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    @Override
    public String toString() {
        return "CardVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sysName='" + sysName + '\'' +
                '}';
    }
}
