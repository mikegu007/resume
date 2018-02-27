package com.mike.resume.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class COrder implements Serializable {
    private String orderNo;

    private Integer openId;

    private Date createTime;

    private Date payTime;

    private BigDecimal amountActual;

    private BigDecimal amount;

    private Integer detailCount;

    private Byte status;

    private Boolean hasPay;

    private String remark;

    private Boolean delFlag;

    private List<COrderDetail> cOrderDetails;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getAmountActual() {
        return amountActual;
    }

    public void setAmountActual(BigDecimal amountActual) {
        this.amountActual = amountActual;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Integer detailCount) {
        this.detailCount = detailCount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Boolean getHasPay() {
        return hasPay;
    }

    public void setHasPay(Boolean hasPay) {
        this.hasPay = hasPay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public List<COrderDetail> getcOrderDetails() {
        return cOrderDetails;
    }

    public void setcOrderDetails(List<COrderDetail> cOrderDetails) {
        this.cOrderDetails = cOrderDetails;
    }
}