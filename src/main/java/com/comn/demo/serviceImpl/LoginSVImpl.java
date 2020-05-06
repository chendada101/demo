package com.comn.demo.serviceImpl;

import com.comn.demo.beans.ChannlCallUserRole;
import com.comn.demo.beans.ChannlH5CallPerson;
import com.comn.demo.dao.ChannlCallUserRoleDAO;
import com.comn.demo.dao.ChannlH5CallPersonDAO;
import com.comn.demo.iservice.LoginSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class LoginSVImpl implements LoginSV {
    @Autowired
    private ChannlH5CallPersonDAO channlH5CallPersonDAO;
    @Autowired
    private ChannlCallUserRoleDAO channlCallUserRoleDAO;
    @Override
    public List<Map<String, Object>> selectRoleListByTel(String telPhone) {
        List<Map<String, Object>> list = channlCallUserRoleDAO.selectRoleListByTel(telPhone);
        return list;
    }

    @Override
    public int registerCallPerson(ChannlH5CallPerson channlH5CallPerson) throws Exception {
        try {
            channlH5CallPersonDAO.insertSelective(channlH5CallPerson);
            //插入角色数据
            String telnum = channlH5CallPerson.getPrsnTelnum();
            List<ChannlCallUserRole> listRole = new ArrayList<>();
            Date date = new Date();
            ChannlCallUserRole userRole = new ChannlCallUserRole(null,telnum,"01",null,date,null,null,null,null);
            listRole.add(userRole);
            if("是".equals(channlH5CallPerson.getHallAdminFlag())){
                ChannlCallUserRole adminRole = new ChannlCallUserRole(null,telnum,"04",null,date,null,null,null,null);
                listRole.add(adminRole);
            }
            channlCallUserRoleDAO.insertAllUserRole(listRole);
            return 1;
        }catch(Exception e){
            throw new Exception(e);
        }


    }


    @Override
    public ChannlH5CallPerson selectUserByUsername(String telnum) {
        return channlH5CallPersonDAO.selectUserByUsername(telnum);
    }
}
