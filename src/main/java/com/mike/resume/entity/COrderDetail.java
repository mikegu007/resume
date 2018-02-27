package com.mike.resume.entity;

import java.io.Serializable;

public class COrderDetail implements Serializable {
    private Integer id;

    private String orderNo;

    private Integer productId;

    private Boolean delFlag;

    private CProduct cProduct;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    public CProduct getcProduct() {
        return cProduct;
    }

    public void setcProduct(CProduct cProduct) {
        this.cProduct = cProduct;
    }
}