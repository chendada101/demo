package com.comn.demo.beans;

import java.util.Date;

public class BussinResult {
    private Integer callId;

    private String telnum;

    private String taskName;

    private String newBussinResult;

    private String oldBussinResult;

    private String state;

    private Date subtime;

    private String isUpdate;

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum == null ? null : telnum.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getNewBussinResult() {
        return newBussinResult;
    }

    public void setNewBussinResult(String newBussinResult) {
        this.newBussinResult = newBussinResult == null ? null : newBussinResult.trim();
    }

    public String getOldBussinResult() {
        return oldBussinResult;
    }

    public void setOldBussinResult(String oldBussinResult) {
        this.oldBussinResult = oldBussinResult == null ? null : oldBussinResult.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public String getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate == null ? null : isUpdate.trim();
    }
}