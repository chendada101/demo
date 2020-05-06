package com.comn.demo.beans;

import java.util.Date;

public class ChannlH5CallPerson {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private String belgProvCode;

    private String belgCityCode;

    private String belgDistrtCode;

    private String prsnName;

    private String prsnPassword;

    private String prsnTelnum;

    private String stsCd;

    private Date   crtTime;

    private String chnlStaffNum;

    private String hallAdminFlag;

    private String cmccolChnlName;

    private String cmccolChnlId;

    private String imageIddress;



    public String getBelgProvCode() {
        return belgProvCode;
    }

    public void setBelgProvCode(String belgProvCode) {
        this.belgProvCode = belgProvCode == null ? null : belgProvCode.trim();
    }

    public String getBelgCityCode() {
        return belgCityCode;
    }

    public void setBelgCityCode(String belgCityCode) {
        this.belgCityCode = belgCityCode == null ? null : belgCityCode.trim();
    }

    public String getBelgDistrtCode() {
        return belgDistrtCode;
    }

    public void setBelgDistrtCode(String belgDistrtCode) {
        this.belgDistrtCode = belgDistrtCode == null ? null : belgDistrtCode.trim();
    }

    public String getPrsnName() {
        return prsnName;
    }

    public void setPrsnName(String prsnName) {
        this.prsnName = prsnName == null ? null : prsnName.trim();
    }

    public String getPrsnPassword() {
        return prsnPassword;
    }

    public void setPrsnPassword(String prsnPassword) {
        this.prsnPassword = prsnPassword == null ? null : prsnPassword.trim();
    }

    public String getPrsnTelnum() {
        return prsnTelnum;
    }

    public void setPrsnTelnum(String prsnTelnum) {
        this.prsnTelnum = prsnTelnum == null ? null : prsnTelnum.trim();
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd == null ? null : stsCd.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getChnlStaffNum() {
        return chnlStaffNum;
    }

    public void setChnlStaffNum(String chnlStaffNum) {
        this.chnlStaffNum = chnlStaffNum == null ? null : chnlStaffNum.trim();
    }

    public String getHallAdminFlag() {
        return hallAdminFlag;
    }

    public void setHallAdminFlag(String hallAdminFlag) {
        this.hallAdminFlag = hallAdminFlag == null ? null : hallAdminFlag.trim();
    }

    public String getCmccolChnlName() {
        return cmccolChnlName;
    }

    public void setCmccolChnlName(String cmccolChnlName) {
        this.cmccolChnlName = cmccolChnlName == null ? null : cmccolChnlName.trim();
    }

    public String getCmccolChnlId() {
        return cmccolChnlId;
    }

    public void setCmccolChnlId(String cmccolChnlId) {
        this.cmccolChnlId = cmccolChnlId == null ? null : cmccolChnlId.trim();
    }

    public String getImageIddress() {
        return imageIddress;
    }

    public void setImageIddress(String imageIddress) {
        this.imageIddress = imageIddress == null ? null : imageIddress.trim();
    }
}