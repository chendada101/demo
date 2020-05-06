package com.comn.demo.dao;

import com.comn.demo.beans.BussinResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface BussinResultDAO {
    int deleteByPrimaryKey(Integer callId);

    int insert(BussinResult record);

    int insertSelective(BussinResult record);

    BussinResult selectByPrimaryKey(Integer callId);

    int updateByPrimaryKeySelective(BussinResult record);

    int updateByPrimaryKey(BussinResult record);

    List<BussinResult> selectWaitList(Map map);

    int selectWaitListTotal(Map map);
}