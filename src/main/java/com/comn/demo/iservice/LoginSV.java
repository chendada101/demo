package com.comn.demo.iservice;

import com.comn.demo.beans.ChannlH5CallPerson;

import java.util.List;
import java.util.Map;

public interface LoginSV {
    List<Map<String,Object>> selectRoleListByTel(String telPhone);

    int registerCallPerson(ChannlH5CallPerson channlH5CallPerson) throws Exception;

     ChannlH5CallPerson selectUserByUsername(String telnum);
}
