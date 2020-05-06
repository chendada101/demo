package com.comn.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChannlCallUserRole {
    private Integer id;

    private String prsnTelnum;

    private String rolePrivCode;

    private String crtUserId;

    private Date crtTime;

    private String crtAppSysId;

    private String modfUserId;

    private String modfAppSysId;

    private Date modfTime;


}