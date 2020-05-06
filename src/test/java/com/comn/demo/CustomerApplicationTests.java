package com.comn.demo;

import com.comn.demo.controller.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.GeneralSecurityException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {
    @Autowired
    LoginController loginController;

    /*
    根据id查找客户
     */
    @Test
    public void selectCustomerByIdTest() throws GeneralSecurityException {
        loginController.queryRoleList("18239193397");
    }

}
