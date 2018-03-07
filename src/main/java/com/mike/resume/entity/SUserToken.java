package com.mike.resume.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户登录
 * @author Mike
 * @date 2018/3/7
 */
public class SUserToken implements Serializable {
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 盐
     */
    private String salt;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}