package com.mike.resume.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
     * 删除标识
     */
    private Boolean delFlag;
    /**
     * 产品分类名
     */
    private String pCategoryName;
    /**-
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

//    /**
//     * 产品数量
//     */
//    private Integer count;


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


    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }


    /**
     * 获取
     *
     * @return pCategoryName
     */
    public String getpCategoryName() {
        return pCategoryName;
    }

    public void setpCategoryName(String pCategoryName) {
        this.pCategoryName = pCategoryName;
    }

    /**
     * 获取
     *
     * @return pName
     */
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * 获取
     *
     * @return pDes
     */
    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    /**
     * 获取
     *
     * @return pProPicUrl
     */
    public String getpProPicUrl() {
        return pProPicUrl;
    }

    public void setpProPicUrl(String pProPicUrl) {
        this.pProPicUrl = pProPicUrl;
    }

    /**
     * 获取
     *
     * @return pPrice
     */
    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * 获取
     *
     * @return pTasteName
     */
    public String getpTasteName() {
        return pTasteName;
    }

    public void setpTasteName(String pTasteName) {
        this.pTasteName = pTasteName;
    }

    /**
     * 获取
     *
     * @return pSizeName
     */
    public String getpSizeName() {
        return pSizeName;
    }

    public void setpSizeName(String pSizeName) {
        this.pSizeName = pSizeName;
    }

    /**
     * 获取
     *
     * @return count
     */
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
}