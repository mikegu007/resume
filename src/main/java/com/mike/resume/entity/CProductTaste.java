package com.mike.resume.entity;

import java.io.Serializable;
/**
 * 产品口味实体
 * @author Mike
 * @date 2018/3/7
 */
public class CProductTaste implements Serializable {
    private Integer id;
    /**
     * 关联产品ID
     */
    private Integer cProductId;
    /**
     * 产品口味名称
     */
    private String tasteName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcProductId() {
        return cProductId;
    }

    public void setcProductId(Integer cProductId) {
        this.cProductId = cProductId;
    }

    public String getTasteName() {
        return tasteName;
    }

    public void setTasteName(String tasteName) {
        this.tasteName = tasteName == null ? null : tasteName.trim();
    }
}