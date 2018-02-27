package com.mike.resume.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CProduct implements Serializable {
    private Integer id;

    private String categoryName;

    private String name;

    private String des;

    private String proPicUrl;

    private BigDecimal price;

    private Boolean enable;

    private Boolean delFlag;

    private List<CProductSize> cProductSizes;

    private List<CProductTaste> cProductTastes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getProPicUrl() {
        return proPicUrl;
    }

    public void setProPicUrl(String proPicUrl) {
        this.proPicUrl = proPicUrl == null ? null : proPicUrl.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public List<CProductSize> getcProductSizes() {
        return cProductSizes;
    }

    public void setcProductSizes(List<CProductSize> cProductSizes) {
        this.cProductSizes = cProductSizes;
    }

    public List<CProductTaste> getcProductTastes() {
        return cProductTastes;
    }

    public void setcProductTastes(List<CProductTaste> cProductTastes) {
        this.cProductTastes = cProductTastes;
    }
}