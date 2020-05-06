package com.comn.demo.beans;

import java.util.Date;

public class ChannlInfo {
    private Integer cmccolChnlId;

    public void setCmccolChnlId(Integer cmccolChnlId) {
        this.cmccolChnlId = cmccolChnlId;
    }

    public Integer getCmccolChnlId() {
        return cmccolChnlId;
    }

    private String custTelnum;

    private String custName;

    private String belgProvCode;

    private String belgCityCode;

    private String belgDistrtCode;

    private String provChnlId;

    private String validStsCd;

    private String physclStoreNm;

    private String physclUserTotal;

    private String physclStoreAddr;

    private Date crtTime;
    private String areaName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCustTelnum() {
        return custTelnum;
    }

    public void setCustTelnum(String custTelnum) {
        this.custTelnum = custTelnum == null ? null : custTelnum.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

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

    public String getProvChnlId() {
        return provChnlId;
    }

    public void setProvChnlId(String provChnlId) {
        this.provChnlId = provChnlId == null ? null : provChnlId.trim();
    }

    public String getValidStsCd() {
        return validStsCd;
    }

    public void setValidStsCd(String validStsCd) {
        this.validStsCd = validStsCd == null ? null : validStsCd.trim();
    }

    public String getPhysclStoreNm() {
        return physclStoreNm;
    }

    public void setPhysclStoreNm(String physclStoreNm) {
        this.physclStoreNm = physclStoreNm == null ? null : physclStoreNm.trim();
    }

    public String getPhysclUserTotal() {
        return physclUserTotal;
    }

    public void setPhysclUserTotal(String physclUserTotal) {
        this.physclUserTotal = physclUserTotal == null ? null : physclUserTotal.trim();
    }

    public String getPhysclStoreAddr() {
        return physclStoreAddr;
    }

    public void setPhysclStoreAddr(String physclStoreAddr) {
        this.physclStoreAddr = physclStoreAddr == null ? null : physclStoreAddr.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}