package com.mike.resume.entity;

import java.io.Serializable;
/**
 * 订单明细
 * @author Mike
 * @date 2018/3/7
 */
public class COrderDetail implements Serializable {
    private Integer id;
    /**
     * 关联订单号唯一标识
     */
    private String orderNo;
    /**
     * 关联产品ID
     */
    private Integer productId;
    /**
     * 删除标志
     */
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