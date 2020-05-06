package com.comn.demo.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.comn.demo.beans.ChannlH5CallPerson;
import com.comn.demo.beans.Task;
import com.comn.demo.iservice.LoginSV;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class LoginController {

    /**
     *
     */
    private static final Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private LoginSV loginSV;
    @RequestMapping(value = "/queryRoleList", method = RequestMethod.POST)
    public Map<String, Object>  queryRoleList(String telPhone) throws GeneralSecurityException {
        Map<String,Object> mapResult = new HashMap<>();
        List<Map<String, Object>> roleListByTel = loginSV.selectRoleListByTel(telPhone);
        if(CollectionUtils.isNotEmpty(roleListByTel)){
            mapResult.put("returnMessage","查询用户信息成功");
            mapResult.put("beans",roleListByTel);
        }
        else{
            mapResult.put("returnMessage","用户信息不存在");
        }
        logger.info("---------------"+roleListByTel.toString());
        return mapResult;

    }

    /**
     * 验证用户名密码
     */
    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public Map<String,Object> login(String telnum, String password, HttpServletRequest request){
        Map<String,Object> mapResult = new HashMap<>();
        ChannlH5CallPerson channlH5CallPeople = loginSV.selectUserByUsername(telnum);
        if (channlH5CallPeople != null && channlH5CallPeople.getPrsnPassword().equals(password)){
            request.getSession().setAttribute("User",channlH5CallPeople);
            logger.info("--------");
            Object user = request.getSession().getAttribute("User");
            logger.info("--------"+user.toString());
            mapResult.put("returnMessage","登录成功");
            return mapResult;
        }else {
            mapResult.put("returnMessage","手机号或者密码错误");
            return mapResult;
        }
    }

    @RequestMapping("/registerCallPerson")
    public Map<String,Object> registerCallPerson(ChannlH5CallPerson channlH5CallPerson) throws Exception {
        Map<String,Object> mapResult = new HashMap<>();
        ChannlH5CallPerson callPerson= loginSV.selectUserByUsername(channlH5CallPerson.getPrsnTelnum());
        if(callPerson==null){
            Date date = new Date();
            channlH5CallPerson.setCrtTime(date);
            int flag = loginSV.registerCallPerson(channlH5CallPerson);
            if(flag>0){
                mapResult.put("returnMessage","注册成功");
            }
            else{
                mapResult.put("returnMessage","注册失败");
            }
        }else{
            //注册失败
            mapResult.put("returnMessage","手机号已存在");
        }

        return mapResult;
    }

    @RequestMapping("/toLogin")
    public Map<String,Object> toLogin(){
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("returnMessage","没有权限请先去登录");
        return mapResult;
    }
}
