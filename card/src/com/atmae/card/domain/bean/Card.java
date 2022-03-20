package com.atmae.card.domain.bean;

/**
 * @Author: Mae
 * @Date: 2022/3/18
 * @Time: 11:14
 * @Description:
 */
public class Card {
    Long id;
    String name;
    String gender;
    String account;
    String password;
    String email;
    Long userId;
    Integer delField;

    public Card(Long id, String name, String gender, String account, String password, String email, Long userId, Integer delField) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.account = account;
        this.password = password;
        this.email = email;
        this.userId = userId;
        this.delField = delField;
    }

    public Card() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDelField() {
        return delField;
    }

    public void setDelField(Integer delField) {
        this.delField = delField;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", delField=" + delField +
                '}';
    }
}

