package com.comn.demo.dao;

import com.comn.demo.beans.RegnInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RegnInfoDAO {
    int deleteByPrimaryKey(Short regnCode);

    int insert(RegnInfo record);

    int insertSelective(RegnInfo record);

    RegnInfo selectByPrimaryKey(Short regnCode);

    int updateByPrimaryKeySelective(RegnInfo record);

    int updateByPrimaryKey(RegnInfo record);

    List<Map<String,Object>> selectRegnInfo(Short superRegnCode);

    String selectNameByCode(Short belgProvCode);
}