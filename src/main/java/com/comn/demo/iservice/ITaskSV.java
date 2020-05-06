package com.comn.demo.iservice;

import com.comn.demo.beans.Task;

import java.util.List;
import java.util.Map;

public interface ITaskSV {
    List<Task> selectTaskList(Map<String,Object> map);

    int selectTaskTotal(Map<String,Object> mapParam);

    int insertTaskList(Task task);

    int deleteTaskList(int taskId);

    Task selectTaskById(int taskId);

    int updateTask(Task task);
}
