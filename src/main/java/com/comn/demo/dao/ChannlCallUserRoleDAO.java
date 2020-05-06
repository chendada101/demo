package com.comn.demo.dao;

import com.comn.demo.beans.ChannlCallUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ChannlCallUserRoleDAO {
    int insert(ChannlCallUserRole record);

    int insertSelective(ChannlCallUserRole record);

    List<Map<String,Object>> selectRoleListByTel(String telPhone);

    void insertAllUserRole(@Param("listRole") List<ChannlCallUserRole> listRole);

    void deleteAllUserRole(Map<String,Object> closeMap);

    void deleteUserRole(@Param("prsnTelnum")String prsnTelnum, @Param("staffPower")String staffPower);
}