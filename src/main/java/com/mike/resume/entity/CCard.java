package com.mike.resume.entity;

import java.io.Serializable;
/**
 * 购物车实体
 * @author Mike
 * @date 2018/3/7
 */
public class CCard implements Serializable {
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 关联产品ID
     */
    private Integer productId;
    /**
     * 删除标识
     */
    private Boolean delFlag;

    private CProduct cProduct;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取
     *
     * @return cProduct
     */
    public CProduct getcProduct() {
        return cProduct;
    }

    public void setcProduct(CProduct cProduct) {
        this.cProduct = cProduct;
    }
}