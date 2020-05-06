package com.comn.demo.serviceImpl;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.comn.demo.beans.ChannlCallUserRole;
import com.comn.demo.beans.ChannlH5CallPerson;
import com.comn.demo.beans.ChannlInfo;
import com.comn.demo.dao.ChannlCallUserRoleDAO;
import com.comn.demo.dao.ChannlH5CallPersonDAO;
import com.comn.demo.dao.ChannlInfoDAO;
import com.comn.demo.dao.RegnInfoDAO;
import com.comn.demo.iservice.IHallmanagerSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.CountDownLatch;

@Service
@Transactional
public class HallmanagerSVImpl implements IHallmanagerSV {
    private String stateOpen = "0";
    private String stateColse = "1";
    @Autowired
    private RegnInfoDAO regnInfoDAO;
    @Autowired
    private ChannlInfoDAO channlInfoDAO;
    @Autowired
    private ChannlH5CallPersonDAO channlH5CallPersonDAO;
    @Autowired
    private ChannlCallUserRoleDAO channlCallUserRoleDAO;
    @Override
    public List<Map<String, Object>> selectRegnInfo(Short superRegnCode) {
        return regnInfoDAO.selectRegnInfo(superRegnCode);
    }

    @Override
    public Map<String, Object> selectChannList(Map<String, Object> mapParam) {
        List<ChannlInfo> channlInfoList = channlInfoDAO.selectChannList(mapParam);
        for (ChannlInfo channlInfo :channlInfoList) {
            String provName = "";
            String cityName = "";
            String distrtName = "";
            if(!StringUtils.isEmpty(channlInfo.getBelgProvCode().trim())){
                provName = regnInfoDAO.selectNameByCode(Short.valueOf(channlInfo.getBelgProvCode()));
            }
            if(!StringUtils.isEmpty(channlInfo.getBelgCityCode().trim())){
                cityName = regnInfoDAO.selectNameByCode(Short.valueOf(channlInfo.getBelgCityCode()));
            }
            if(!StringUtils.isEmpty(channlInfo.getBelgDistrtCode().trim())){
                distrtName = regnInfoDAO.selectNameByCode(Short.valueOf(channlInfo.getBelgDistrtCode()));
            }
            String areaName = provName+" "+cityName+" "+distrtName;
            channlInfo.setAreaName(areaName);
            Map<String,Object> map = new HashMap<>();
            map.put("cmccolChnlId",channlInfo.getCmccolChnlId());
            int total = channlH5CallPersonDAO.selectPersonListTotal(map);
            if(total>0){
                channlInfo.setPhysclUserTotal(String.valueOf(total));
            }else{
                channlInfo.setPhysclUserTotal("0");
            }
        }
        int total = channlInfoDAO.selectChannListTotal(mapParam);
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("beans",channlInfoList);
        mapResult.put("total",total);

        return mapResult;
    }

    @Override
    public Map<String, Object> selectCallPersonList(Map<String, Object> mapParam) {
        List<ChannlH5CallPerson> callList = channlH5CallPersonDAO.selectCallPersonList(mapParam);
        int total = channlH5CallPersonDAO.selectPersonListTotal(mapParam);
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("beans",callList);
        mapResult.put("total",total);
        return mapResult;
    }

    @Override
    public int updateChannlState(int cmccolChnlId, String state) throws GenericException {
        //修改厅店状态
        ChannlInfo channlInfo = new ChannlInfo();
        channlInfo.setCmccolChnlId(cmccolChnlId);
        channlInfo.setValidStsCd(state);
        int num = channlInfoDAO.updateByPrimaryKeySelective(channlInfo);
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("cmccolChnlId",cmccolChnlId);
        List<ChannlH5CallPerson> personList = channlH5CallPersonDAO.selectCallPersonList(mapParam);

        if(!CollectionUtils.isEmpty(personList)){
            Map<String,Object> updateMap = new HashMap<>();
            updateMap.put("state",state);
            updateMap.put("personList",personList);
            channlH5CallPersonDAO.updateCallState(updateMap);
             //启用
            if(stateOpen.equals(state)){
                //插入角色数据
                List<ChannlCallUserRole> listRole = new ArrayList<>();
                for (ChannlH5CallPerson callPerson: personList) {
                    String telnum = callPerson.getPrsnTelnum();
                    Date date = new Date();
                    ChannlCallUserRole userRole = new ChannlCallUserRole(null,telnum,"01",null,date,null,null,null,null);
                    listRole.add(userRole);
                    if("是".equals(callPerson.getHallAdminFlag())){
                        ChannlCallUserRole adminRole = new ChannlCallUserRole(null,telnum,"04",null,date,null,null,null,null);
                        listRole.add(adminRole);
                    }
                }
                try {
                    channlCallUserRoleDAO.insertAllUserRole(listRole);
                }catch (Exception e){
                    throw new GenericException(e);

                }
            }
            //禁用
            if(stateColse.equals(state)){
                //删除角色数据
                Map<String,Object> closeMap = new HashMap<>();
                closeMap.put("staffPower","01");
                closeMap.put("personList",personList);
                channlCallUserRoleDAO.deleteAllUserRole(closeMap);

                for (ChannlH5CallPerson callPerson: personList) {
                    if("是".equals(callPerson.getHallAdminFlag())){
                        String prsnTelnum = callPerson.getPrsnTelnum();
                        channlCallUserRoleDAO.deleteUserRole(prsnTelnum,"04");
                    }
                }
            }
        }
        return num;
    }

    @Override
    public int updateCallPersonState(int id, String state) {
        ChannlH5CallPerson channlH5CallPerson = new ChannlH5CallPerson();
        channlH5CallPerson.setId(id);
        channlH5CallPerson.setStsCd(state);
        channlH5CallPersonDAO.updateByPrimaryKeySelective(channlH5CallPerson);
        ChannlH5CallPerson callPerson = channlH5CallPersonDAO.selectByPrimaryKey(id);
        //插入角色数据
        List<ChannlCallUserRole> listRole = new ArrayList<>();
        //启用
        if("0".equals(state)){

            String telnum = callPerson.getPrsnTelnum();
            Date date = new Date();
            ChannlCallUserRole userRole = new ChannlCallUserRole(null,telnum,"01",null,date,null,null,null,null);
            listRole.add(userRole);
            if("是".equals(callPerson.getHallAdminFlag())){
                ChannlCallUserRole adminRole = new ChannlCallUserRole(null,telnum,"04",null,date,null,null,null,null);
                listRole.add(adminRole);
            }
            try {
                channlCallUserRoleDAO.insertAllUserRole(listRole);
            }catch (Exception e){
                throw new GenericException(e);
            }
        }
        //禁用
        if(stateColse.equals(state)){
            //删除角色数据
            channlCallUserRoleDAO.deleteUserRole(callPerson.getPrsnTelnum(),"01");
            if("是".equals(callPerson.getHallAdminFlag())){
                channlCallUserRoleDAO.deleteUserRole(callPerson.getPrsnTelnum(),"04");
            }

        }

        return 0;
    }

    @Override
    public int insertChannl(ChannlInfo channlInfo) {
        return channlInfoDAO.insertSelective(channlInfo);
    }

    @Override
    public List<Map<String, Object>> selectOpenChannList() {
        return channlInfoDAO.selectOpenChannList();
    }


}
