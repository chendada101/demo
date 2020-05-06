package com.comn.demo.iservice;

import com.comn.demo.beans.ChannlInfo;

import java.util.List;
import java.util.Map;

public interface IHallmanagerSV {
    List<Map<String,Object>> selectRegnInfo(Short superRegnCode);

    Map<String,Object> selectChannList(Map<String,Object> mapParam);

    Map<String,Object> selectCallPersonList(Map<String,Object> mapParam);


    int updateChannlState(int cmccolChnlId, String state);

    int updateCallPersonState(int id, String state);

    int insertChannl(ChannlInfo channlInfo);

    List<Map<String,Object>> selectOpenChannList();
}
