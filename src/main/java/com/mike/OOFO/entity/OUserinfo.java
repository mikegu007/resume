package com.mike.OOFO.entity;

import java.io.Serializable;
import java.util.Date;

public class OUserinfo implements Serializable {
    private Integer id;

    private Date createTime;

    private Boolean delFlag;

    private Integer userId;

    private String intention;

    private String birth;

    private String zodiac;

    private String constellation;

    private String nationality;

    private String height;

    private String weight;

    private String marriage;

    private String education;

    private String residence;

    private String register;

    private String profession;

    private String family;

    private String income;

    private String interest;

    private String isOtherLove;

    private String yearToMerry;

    private String haveKid;

    private String smailRequire;

    private String specialRequire;

    private String aboutUs;

    private String pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention == null ? null : intention.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac == null ? null : zodiac.trim();
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence == null ? null : residence.trim();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family == null ? null : family.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getIsOtherLove() {
        return isOtherLove;
    }

    public void setIsOtherLove(String isOtherLove) {
        this.isOtherLove = isOtherLove == null ? null : isOtherLove.trim();
    }

    public String getYearToMerry() {
        return yearToMerry;
    }

    public void setYearToMerry(String yearToMerry) {
        this.yearToMerry = yearToMerry == null ? null : yearToMerry.trim();
    }

    public String getHaveKid() {
        return haveKid;
    }

    public void setHaveKid(String haveKid) {
        this.haveKid = haveKid == null ? null : haveKid.trim();
    }

    public String getSmailRequire() {
        return smailRequire;
    }

    public void setSmailRequire(String smailRequire) {
        this.smailRequire = smailRequire == null ? null : smailRequire.trim();
    }

    public String getSpecialRequire() {
        return specialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        this.specialRequire = specialRequire == null ? null : specialRequire.trim();
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs == null ? null : aboutUs.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}