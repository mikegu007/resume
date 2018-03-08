package com.mike.resume.entity;

import java.math.BigDecimal;

public class COrderDetail {
    private Integer id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 删除标志
     */
    private Boolean delFlag;
    /**
     * 产品分类名
     */
    private String pCategoryName;
    /**
     * 产品名
     */
    private String pName;
    /**
     * 产品描述
     */
    private String pDes;
    /**
     * 产品图片路劲
     */
    private String pProPicUrl;
    /**
     * 产品价格
     */
    private BigDecimal pPrice;
    /**
     * 产品口味名
     */
    private String pTasteName;
    /**
     * 产品规格名
     */
    private String pSizeName;

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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getpCategoryName() {
        return pCategoryName;
    }

    public void setpCategoryName(String pCategoryName) {
        this.pCategoryName = pCategoryName == null ? null : pCategoryName.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes == null ? null : pDes.trim();
    }

    public String getpProPicUrl() {
        return pProPicUrl;
    }

    public void setpProPicUrl(String pProPicUrl) {
        this.pProPicUrl = pProPicUrl == null ? null : pProPicUrl.trim();
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public String getpTasteName() {
        return pTasteName;
    }

    public void setpTasteName(String pTasteName) {
        this.pTasteName = pTasteName == null ? null : pTasteName.trim();
    }

    public String getpSizeName() {
        return pSizeName;
    }

    public void setpSizeName(String pSizeName) {
        this.pSizeName = pSizeName == null ? null : pSizeName.trim();
    }
}