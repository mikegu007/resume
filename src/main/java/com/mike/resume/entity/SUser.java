package com.mike.resume.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 用户信息
 * @author Mike
 * @date 2018/3/7
 */
public class SUser implements Serializable{
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 城市
     */
    private String city;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;
    /**
     * 语言
     */
    private String language;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 删除标识
     */
    private Boolean delFlag;

    private List<SUserAddress> sUserAddresses;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public List<SUserAddress> getsUserAddresses() {
        return sUserAddresses;
    }

    public void setsUserAddresses(List<SUserAddress> sUserAddresses) {
        this.sUserAddresses = sUserAddresses;
    }
}