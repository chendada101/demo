package com.comn.demo.controller;

import com.comn.demo.beans.BussinResult;
import com.comn.demo.iservice.IBussinResultSV;
import org.apache.log4j.Logger;
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
public class BussinResultController {
    @Autowired
    private IBussinResultSV iBussinResultSV;
    private static final Logger logger = Logger.getLogger(BussinResultController.class);

  @RequestMapping("/selectBussinResultList")
  private Map selectBussinResultList(String taskName,String result,String state,String isUpdate,int start,int limit){
      logger.info("selectTaskList入参：start"+start+",limit"+limit+",taskName"+taskName+",result"+result+",state"+state+",isUpdate"+isUpdate);
      Map<String,Object> mapParam = new HashMap<>();
      mapParam.put("taskName",taskName);
      mapParam.put("result",result);
      mapParam.put("state",state);
      mapParam.put("isUpdate",isUpdate);
      mapParam.put("start",start);
      mapParam.put("limit",limit);
      List<BussinResult> list  = iBussinResultSV.selectWaitList(mapParam);
      int total = iBussinResultSV.selectWaitListTotal(mapParam);
      Map<String,Object> mapResult = new HashMap<>();
      mapResult.put("beans",list);
      mapResult.put("total",total);
      return mapResult;
   }

    @RequestMapping("/insertBussinResult")
    private Map insertBussinResult(BussinResult bussinResult){
      Date date = new Date();
      bussinResult.setSubtime(date);
      int flag = iBussinResultSV.insertBussinResult(bussinResult);
      Map<String,Object> mapResult = new HashMap<>();
      if(flag>0){
         mapResult.put("returnMessage","插入成功");
      }
      else{
         mapResult.put("returnMessage","插入失败");
      }
        return mapResult;
    }


    @RequestMapping("/selectBussinResultById")
    private BussinResult selectBussinResultById(int callId){
        BussinResult bussinResult = iBussinResultSV.selectBussinResultById(callId);
        return bussinResult;
    }

    @RequestMapping("/updateBussinResult")
    private Map updateBussinResult(BussinResult bussinResult){
        int flag = iBussinResultSV.updateBussinResult(bussinResult);
        Map<String,Object> mapResult = new HashMap<>();
        if(flag>0){
            mapResult.put("returnMessage","修改成功");
        }
        else{
            mapResult.put("returnMessage","修改失败");
        }
        return mapResult;
    }
}
