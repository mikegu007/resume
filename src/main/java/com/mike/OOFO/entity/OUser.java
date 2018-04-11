package com.mike.OOFO.entity;

import java.io.Serializable;
import java.util.Date;

public class OUser implements Serializable{
    private Integer id;

    private Date createTime;

    private Boolean delFlag;

    private String openId;

    private String name;

    private Byte sex;

    private String eduCode;

    private String idcardCode;

    private String idcardFon;

    private String idcardBac;

    private String wechatCode;

    private String phone;

    private String profession;

    private String company;

    private Byte status;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode == null ? null : eduCode.trim();
    }

    public String getIdcardCode() {
        return idcardCode;
    }

    public void setIdcardCode(String idcardCode) {
        this.idcardCode = idcardCode == null ? null : idcardCode.trim();
    }

    public String getIdcardFon() {
        return idcardFon;
    }

    public void setIdcardFon(String idcardFon) {
        this.idcardFon = idcardFon == null ? null : idcardFon.trim();
    }

    public String getIdcardBac() {
        return idcardBac;
    }

    public void setIdcardBac(String idcardBac) {
        this.idcardBac = idcardBac == null ? null : idcardBac.trim();
    }

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode == null ? null : wechatCode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}