package com.comn.demo.dao;

import com.comn.demo.beans.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface TaskDAO {
    int deleteByPrimaryKey(Integer taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
    List<Task> selectTaskList(Map<String,Object> map);

    int selectTaskTotal(Map<String,Object> mapParam);
}