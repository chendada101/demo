package com.comn.demo.dao;

import com.comn.demo.beans.ChannlInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ChannlInfoDAO {
    int deleteByPrimaryKey(Integer cmccolChnlId);

    int insert(ChannlInfo record);

    int insertSelective(ChannlInfo record);

    ChannlInfo selectByPrimaryKey(Integer cmccolChnlId);

    int updateByPrimaryKeySelective(ChannlInfo record);

    int updateByPrimaryKey(ChannlInfo record);
    List<ChannlInfo> selectChannList(Map<String,Object> mapParam);

    int selectChannListTotal(Map<String,Object> mapParam);

    List<Map<String,Object>> selectOpenChannList();
}