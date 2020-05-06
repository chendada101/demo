package com.comn.demo.controller;

import com.comn.demo.beans.Task;
import com.comn.demo.iservice.ITaskSV;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TaskController {

    private static final Logger logger = Logger.getLogger(TaskController.class);
    @Autowired
    private ITaskSV iTaskSV;

    @RequestMapping (value = "/selectTaskList",method = RequestMethod.POST)
    public Map<String,Object> selectTaskList( String taskName, int start, int limit){
        logger.info("selectTaskList入参：start"+start+",limit"+limit+",taskName"+taskName);
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("taskName",taskName);
        mapParam.put("start",start);
        mapParam.put("limit",limit);
        List<Task> taskList= iTaskSV.selectTaskList(mapParam);
        int total = iTaskSV.selectTaskTotal(mapParam);
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("beans",taskList);
        mapResult.put("total",total);
        return mapResult;
    }

    @RequestMapping("/insertTask")
    public Map<String,Object> insertTaskList(Task task){
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iTaskSV.insertTaskList(task);
        if(flag>0){
            mapResult.put("returnMessage","插入成功");
        }
        else{
            mapResult.put("returnMessage","插入失败");
        }
        return mapResult;
    }

    @RequestMapping("/deleteTask")
    public Map<String,Object> deleteTaskList(int taskId){
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iTaskSV.deleteTaskList(taskId);
        if(flag>0){
            mapResult.put("returnMessage","删除成功");
        }
        else{
            mapResult.put("returnMessage","删除失败");
        }
        return mapResult;
    }

    @RequestMapping("/selectTaskById")
    public Task selectTaskById(int taskId){

        Task task = iTaskSV.selectTaskById(taskId);

        return task;
    }

    @RequestMapping("/updateTask")
    public Map<String,Object> updateTask(Task task){
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iTaskSV.updateTask(task);
        if(flag>0){
            mapResult.put("returnMessage","修改成功");
        }
        else{
            mapResult.put("returnMessage","修改失败");
        }
        return mapResult;
    }
}
