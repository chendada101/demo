package com.comn.demo.controller;

import com.comn.demo.beans.ChannlInfo;
import com.comn.demo.iservice.IHallmanagerSV;
import com.comn.demo.serviceImpl.HallmanagerSVImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class hallmanagerController {
    @Autowired
    private IHallmanagerSV iHallmanagerSV  = new HallmanagerSVImpl();

    @RequestMapping("/selectRegnInfo")
    public List<Map<String,Object>> selectRegnInfo(Short SuperRegnCode){
        return  iHallmanagerSV.selectRegnInfo(SuperRegnCode);
    }

    @RequestMapping("/selectChannList")
    public Map<String,Object> selectChannList(String belgProvCode,String belgCityCode,String belgDistrtCode,String storeNm,int start,int limit  ){
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("belgProvCode",belgProvCode);
        mapParam.put("belgCityCode",belgCityCode);
        mapParam.put("belgDistrtCode",belgDistrtCode);
        mapParam.put("storeNm",storeNm);
        mapParam.put("start",start);
        mapParam.put("limit",limit);
        Map<String,Object> mapResult = iHallmanagerSV.selectChannList(mapParam);

        return mapResult;
    }
    @RequestMapping("/selectOpenChannList")
    public List<Map<String, Object>> selectOpenChannList(){

        List<Map<String, Object>> mapResult = iHallmanagerSV.selectOpenChannList();

        return mapResult;
    }
    @RequestMapping("/selectCallPersonList")
    public Map<String,Object> selectCallPersonList(String cmccolChnlId,int start,int limit  ){
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("cmccolChnlId",cmccolChnlId);
        mapParam.put("start",start);
        mapParam.put("limit",limit);
        Map<String,Object> mapResult = iHallmanagerSV.selectCallPersonList(mapParam);

        return mapResult;
    }

    @RequestMapping("/updateChannlState")
    public Map<String,Object> updateChannlState(int cmccolChnlId,String state){

        Map<String,Object> mapResult = new HashMap<>();
        int flag = iHallmanagerSV.updateChannlState(cmccolChnlId,state);
        if(flag>0){
            mapResult.put("returnMessage","修改成功");
        }
        else{
            mapResult.put("returnMessage","修改失败");
        }
        return mapResult;
    }

    @RequestMapping("/updateCallPersonState")
    public Map<String,Object> updateCallPersonState(int id,String state){

        Map<String,Object> mapResult = new HashMap<>();
        int flag = iHallmanagerSV.updateCallPersonState(id,state);
        if(flag>0){
            mapResult.put("returnMessage","修改成功");
        }
        else{
            mapResult.put("returnMessage","修改失败");
        }
        return mapResult;
    }

    @RequestMapping("/insertChannl")
    public Map<String,Object> insertChannl(ChannlInfo channlInfo){
        Date date = new Date();
        channlInfo.setCrtTime(date);
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iHallmanagerSV.insertChannl(channlInfo);
        if(flag>0){
            mapResult.put("returnMessage","插入成功");
        }
        else{
            mapResult.put("returnMessage","插入失败");
        }
        return mapResult;
    }
}
