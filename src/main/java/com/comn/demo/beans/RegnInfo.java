package com.comn.demo.beans;

public class RegnInfo {
    private Short regnCode;

    private Short suprRegnCode;

    private String regnNm;

    private Boolean regnLvlCd;

    public Short getRegnCode() {
        return regnCode;
    }

    public void setRegnCode(Short regnCode) {
        this.regnCode = regnCode;
    }

    public Short getSuprRegnCode() {
        return suprRegnCode;
    }

    public void setSuprRegnCode(Short suprRegnCode) {
        this.suprRegnCode = suprRegnCode;
    }

    public String getRegnNm() {
        return regnNm;
    }

    public void setRegnNm(String regnNm) {
        this.regnNm = regnNm == null ? null : regnNm.trim();
    }

    public Boolean getRegnLvlCd() {
        return regnLvlCd;
    }

    public void setRegnLvlCd(Boolean regnLvlCd) {
        this.regnLvlCd = regnLvlCd;
    }
}