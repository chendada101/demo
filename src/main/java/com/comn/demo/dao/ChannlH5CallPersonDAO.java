package com.comn.demo.dao;

import com.comn.demo.beans.ChannlH5CallPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ChannlH5CallPersonDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(ChannlH5CallPerson record);

    int insertSelective(ChannlH5CallPerson record);

    ChannlH5CallPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannlH5CallPerson record);

    int updateByPrimaryKey(ChannlH5CallPerson record);

    List<ChannlH5CallPerson> selectCallPersonList(Map<String,Object> mapParam);

    int selectPersonListTotal(Map<String,Object> map);

    int updateCallState(Map<String,Object> updateMap);


    ChannlH5CallPerson selectUserByUsername(String telnum);
}