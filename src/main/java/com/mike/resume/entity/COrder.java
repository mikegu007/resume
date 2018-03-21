package com.mike.resume.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 订单
 * @author Mike
 * @date 2018/3/7
 */
public class COrder implements Serializable {
    /**
     * 订单号唯一标识
     */
    private String orderNo;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 实际支付金额
     */
    private BigDecimal amountActual;
    /**
     * 支付金额
     */
    private BigDecimal amount;
    /**
     * 明细数量
     */
    private Integer detailCount;
    /**
     * 状态
     */
    private Byte status;
    /**
     * 是否支付标识
     */
    private Boolean hasPay;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除标识
     */
    private Boolean delFlag;
    /**
     * 收件人
     */
    private String sendName;
    /**
     * 收件区域
     */
    private String sendArea;
    /**
     * s收件详情地址
     */
    private String sendAddress;
    /**
     * 收件人电话
     */
    private String sendTelephone;
    /**
     * 收件人邮编
     */
    private String sendPostcode;

    /**
     * 产品规格id
     */
    private Integer cProductSizeId;

    private List<COrderDetail> cOrderDetails;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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

    /**
     * 获取
     *
     * @return sendName
     */
    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /**
     * 获取
     *
     * @return sendArea
     */
    public String getSendArea() {
        return sendArea;
    }

    public void setSendArea(String sendArea) {
        this.sendArea = sendArea;
    }

    /**
     * 获取
     *
     * @return sendAddress
     */
    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    /**
     * 获取
     *
     * @return sendTelephone
     */
    public String getSendTelephone() {
        return sendTelephone;
    }

    public void setSendTelephone(String sendTelephone) {
        this.sendTelephone = sendTelephone;
    }

    /**
     * 获取
     *
     * @return sendPostcode
     */
    public String getSendPostcode() {
        return sendPostcode;
    }

    public void setSendPostcode(String sendPostcode) {
        this.sendPostcode = sendPostcode;
    }

    public Integer getcProductSizeId() {
        return cProductSizeId;
    }

    public void setcProductSizeId(Integer cProductSizeId) {
        this.cProductSizeId = cProductSizeId;
    }
}