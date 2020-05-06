package com.comn.demo.beans;

import java.util.Date;

public class ChannlBanner {
    private Long id;

    private String contentType;

    private String bearMode;

    private String courseName;

    private String imageAddress;

    private String courseAddr;

    private Date crtTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getBearMode() {
        return bearMode;
    }

    public void setBearMode(String bearMode) {
        this.bearMode = bearMode == null ? null : bearMode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress == null ? null : imageAddress.trim();
    }

    public String getCourseAddr() {
        return courseAddr;
    }

    public void setCourseAddr(String courseAddr) {
        this.courseAddr = courseAddr == null ? null : courseAddr.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}