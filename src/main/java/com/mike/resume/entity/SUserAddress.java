package com.mike.resume.entity;

import java.io.Serializable;
/**
 * 用户地址实体
 * @author Mike
 * @date 2018/3/7
 */
public class SUserAddress implements Serializable {
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 邮编
     */
    private String postcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }
}