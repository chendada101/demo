package com.comn.demo.controller;

import com.comn.demo.Utils.AliOSSUtil;
import com.comn.demo.beans.ChannlBanner;
import com.comn.demo.beans.Task;
import com.comn.demo.iservice.IBannerSV;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
public class BannerController {
    private static final Logger logger = Logger.getLogger(BannerController.class);
    @Autowired
    private IBannerSV iBannerSV;

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam(value = "file")MultipartFile file,
                                           HttpServletRequest request) throws IllegalStateException, IOException {
        //1.确定保存的文件夹
        String dirPath = "D:\\javaWork\\Idea\\demo\\src\\main\\resources\\uploadImage";
        logger.info("---------文件夹:"+dirPath);

        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        //2.确定保存的文件名
        String orginalFilename = file.getOriginalFilename();
        int beginIndex = orginalFilename.lastIndexOf(".");
        String suffix ="";
        if(beginIndex!=-1) {
            suffix = orginalFilename.substring(beginIndex);
        }
        String filename =UUID.randomUUID().toString()+suffix;
        //创建文件对象，表示要保存的头像文件,第一个参数表示存储的文件夹，第二个参数表示存储的文件
        File dest = new File(dir,filename);
        //执行保存
        file.transferTo(dest);
        //更新数据表
        String avatar = dirPath+"/"+filename;

        return avatar;
    }
    @RequestMapping("/uploadOSO")
    public String uploadOSO(@RequestParam(value = "file")MultipartFile file) throws IllegalStateException, IOException {
        String url = "";
        if (file != null)
        {
            // 取得当前上传文件的文件名称
            String fileName = file.getOriginalFilename();
            // 如果名称不为空,说明该文件存在，否则说明该文件不存在
            if (fileName.trim() != "") {
                File newFile = new File(fileName);
                FileOutputStream outStream = new FileOutputStream(newFile); // 文件输出流用于将数据写入文件
                outStream.write(file.getBytes());
                outStream.close(); // 关闭文件输出流
                file.transferTo(newFile);
                // 上传到阿里云
                url =AliOSSUtil.upload(newFile);
                newFile.delete();
            }
        }
        return url;
    }


    @RequestMapping (value = "/selectBannerList",method = RequestMethod.POST)
    public Map<String,Object> selectBannerList(){
        Map<String,Object> mapParam = new HashMap<>();
        List<ChannlBanner> bannerList= iBannerSV.selectBannerList(mapParam);
        int total = iBannerSV.selectBannerToatal(mapParam);
        Map<String,Object> mapResult = new HashMap<>();
        mapResult.put("beans",bannerList);
        mapResult.put("total",total);
        return mapResult;
    }

    @RequestMapping("/insertBanner")
    public Map<String,Object> insertTaskList(ChannlBanner channlBanner){
        Map<String,Object> mapResult = new HashMap<>();
        Date date = new Date();
        channlBanner.setCrtTime(date);
        int flag = iBannerSV.insertBanner(channlBanner);
        if(flag>0){
            mapResult.put("returnMessage","插入成功");
        }
        else{
            mapResult.put("returnMessage","插入失败");
        }
        return mapResult;
    }

    @RequestMapping("/deleteBanner")
    public Map<String,Object> deleteTaskList(Long id){
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iBannerSV.deleteBanner(id);
        if(flag>0){
            mapResult.put("returnMessage","删除成功");
        }
        else{
            mapResult.put("returnMessage","删除失败");
        }
        return mapResult;
    }

    @RequestMapping("/selectBannerById")
    public ChannlBanner selectTaskById(Long id){

        ChannlBanner channlBanner = iBannerSV.selectBannerById(id);

        return channlBanner;
    }

    @RequestMapping("/updateBanner")
    public Map<String,Object> updateTask(ChannlBanner channlBanner){
        Map<String,Object> mapResult = new HashMap<>();
        int flag = iBannerSV.updateBanner(channlBanner);
        if(flag>0){
            mapResult.put("returnMessage","修改成功");
        }
        else{
            mapResult.put("returnMessage","修改失败");
        }
        return mapResult;
    }
}
