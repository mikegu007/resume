package com.mike.resume.entity;

import java.util.Date;

public class Lottery {
    private Integer id;

    private String period;

    private Date date;

    private Integer redOne;

    private Integer redTwo;

    private Integer redThree;

    private Integer redFour;

    private Integer redFive;

    private Integer redSix;

    private Integer blueOne;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRedOne() {
        return redOne;
    }

    public void setRedOne(Integer redOne) {
        this.redOne = redOne;
    }

    public Integer getRedTwo() {
        return redTwo;
    }

    public void setRedTwo(Integer redTwo) {
        this.redTwo = redTwo;
    }

    public Integer getRedThree() {
        return redThree;
    }

    public void setRedThree(Integer redThree) {
        this.redThree = redThree;
    }

    public Integer getRedFour() {
        return redFour;
    }

    public void setRedFour(Integer redFour) {
        this.redFour = redFour;
    }

    public Integer getRedFive() {
        return redFive;
    }

    public void setRedFive(Integer redFive) {
        this.redFive = redFive;
    }

    public Integer getRedSix() {
        return redSix;
    }

    public void setRedSix(Integer redSix) {
        this.redSix = redSix;
    }

    public Integer getBlueOne() {
        return blueOne;
    }

    public void setBlueOne(Integer blueOne) {
        this.blueOne = blueOne;
    }
}