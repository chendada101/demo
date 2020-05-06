package com.comn.demo.beans;

import java.util.Date;

public class Task {
    private Integer taskId;

    private String taskName;

    private String taskContent;

    private Date startTime;

    private Date endTime;

    private String taskState;

    private String taskIvr;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState == null ? null : taskState.trim();
    }

    public String getTaskIvr() {
        return taskIvr;
    }

    public void setTaskIvr(String taskIvr) {
        this.taskIvr = taskIvr == null ? null : taskIvr.trim();
    }
}