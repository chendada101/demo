package com.comn.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comn.demo.iservice.DubboProvider;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboTests {
    @Reference
    DubboProvider dubboProvider;
    private static final Logger logger= Logger.getLogger(DubboTests.class);
    @Test
    public void getProvider(){
        String info = dubboProvider.getProvider();
        logger.info(info);
    }


}
