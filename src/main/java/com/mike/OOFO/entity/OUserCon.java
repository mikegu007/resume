package com.mike.OOFO.entity;

import java.io.Serializable;
import java.util.Date;

public class OUserCon implements Serializable {
    private Integer id;

    private Date createTime;

    private Boolean delFlag;

    private Integer userId;

    private String phone;

    private String wechatCode;

    private String qqCode;

    private String weiboCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode == null ? null : wechatCode.trim();
    }

    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode == null ? null : qqCode.trim();
    }

    public String getWeiboCode() {
        return weiboCode;
    }

    public void setWeiboCode(String weiboCode) {
        this.weiboCode = weiboCode == null ? null : weiboCode.trim();
    }
}