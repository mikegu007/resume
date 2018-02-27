package com.mike.resume.entity;

import java.io.Serializable;

public class CProductTaste implements Serializable {
    private Integer id;

    private Integer cProductId;

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