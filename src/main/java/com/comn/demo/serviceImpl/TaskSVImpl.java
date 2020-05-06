package com.comn.demo.serviceImpl;

import com.comn.demo.beans.Task;
import com.comn.demo.dao.TaskDAO;
import com.comn.demo.iservice.ITaskSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TaskSVImpl implements ITaskSV {
    @Autowired
    private TaskDAO taskDAO;

    @Override
    public List<Task> selectTaskList(Map<String, Object> map) {

        return taskDAO.selectTaskList(map);
    }

    @Override
    public int selectTaskTotal(Map<String, Object> mapParam) {
        return taskDAO.selectTaskTotal(mapParam);
    }

    @Override
    public int insertTaskList(Task task) {
        return taskDAO.insertSelective(task);
    }

    @Override
    public int deleteTaskList(int taskId) {
        return taskDAO.deleteByPrimaryKey(taskId);
    }

    @Override
    public Task selectTaskById(int taskId) {
        return taskDAO.selectByPrimaryKey(taskId);
    }

    @Override
    public int updateTask(Task task) {
        return taskDAO.updateByPrimaryKeySelective(task);
    }
}
