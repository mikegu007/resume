package com.mike.resume.entity;

import java.io.Serializable;
/**
 * 产品规格实体
 * @author Mike
 * @date 2018/3/7
 */
public class CProductSize implements Serializable {
    private Integer id;
    /**
     * 关联产品ID
     */
    private Integer cProductId;
    /**
     * 产品规格名
     */
    private String sizeName;

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

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }
}