package com.mike.resume.enums;

/**
 *
 *  订单状态
 * @author Mike
 * @date 2018/3/6
 */
public enum EnumOrderStatus {
    ToPay((byte) 1, "ToPay", "待付款"),
    ToSend((byte) 2, "ToSend", "待发货"),
    ToGet((byte) 3, "ToGet", "待收货"),
    Finished((byte) 4, "Finished", "已完成");

    private Byte statusCode;
    private String nameEN;
    private String nameCN;

    EnumOrderStatus(Byte statusCode, String nameEN, String nameCN) {
        this.statusCode = statusCode;
        this.nameEN = nameEN;
        this.nameCN = nameCN;
    }


    public Byte getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Byte statusCode) {
        this.statusCode = statusCode;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }
}
