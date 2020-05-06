package com.comn.demo.dao;

import com.comn.demo.beans.ChannlBanner;
import com.comn.demo.beans.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChannlBannerDAO {
    int deleteByPrimaryKey(Long id);

    int insert(ChannlBanner record);

    int insertSelective(ChannlBanner record);

    ChannlBanner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannlBanner record);

    int updateByPrimaryKey(ChannlBanner record);

    List<ChannlBanner> selectBannerList(Map<String,Object> mapParam);

    int selectBannerTotal(Map<String,Object> mapParam);
}