package com.comn.demo.Utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class AliOSSUtil {

    private final static Logger log               = Logger.getLogger(AliOSSUtil.class);
    private static String       END_POINT         = "oss-cn-shanghai.aliyuncs.com";
    private static String       ACCESS_KEY_ID     = "";
    private static String       ACCESS_KEY_SECRET = "";
    private static String       BUCKET_NAME       = "xxx-image";
    // 文件访问域名
    private static String       FILE_HOST         = "https://file.xxx.com/";

    /**
     * 方法描述:上传文件
     *
     * @author leon 2016年12月16日 上午11:40:34
     * @param file 文件对象
     * @return
     */
    public static String upload(File file) {
        if (file == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径
            String fileUrl = String.valueOf(UUID.randomUUID());
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, file));
            if (null != result) {
                return FILE_HOST + fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 方法描述:上传文件
     *
     * @author leon 2016年12月26日 下午3:33:13
     * @param inputStream 文件流
     * @return
     * @throws FileNotFoundException
     */
    public static String upload(InputStream inputStream) throws FileNotFoundException {
        if (inputStream == null) {
            return null;
        }
        // 创建OSS客户端
        OSSClient ossClient = new OSSClient(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            // 判断文件容器是否存在，不存在则创建
            if (!ossClient.doesBucketExist(BUCKET_NAME)) {
                ossClient.createBucket(BUCKET_NAME);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(BUCKET_NAME);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 创建文件路径
            String fileUrl = String.valueOf(UUID.randomUUID());
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(BUCKET_NAME, fileUrl, inputStream));
            if (null != result) {
                return FILE_HOST + fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            // 关闭OSS服务，一定要关闭
            ossClient.shutdown();
        }
        return null;

    }

}
