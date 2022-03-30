package com.mhw.rabc.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.UploadFileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @className: OssUtil
 * @description: oss工具类
 * @author: mhw
 * @date: 2022/3/23
 * @version: 1.0
 **/
@Component
public class OssUtil {

    OSS ossClient;
    @Value("${aliyun.oss.bucketName}")
    String bucketName;
    @Value("${aliyun.oss.endpoint}")
    String endpoint;

    @Autowired
    public OssUtil(OSS ossClient) {
        this.ossClient = ossClient;
    }

    // todo 根据回调判断是否上传成功

    /**
     * 简单上传
     *
     * @param name        文件名
     * @param type        文件类型
     * @param inputStream byte[]
     * @return 文件地址
     */
    public String upload(String name, String type, byte[] inputStream) {
        String objectName = rename(name, type);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(inputStream));
        ossClient.putObject(putObjectRequest);
        return "https://" + bucketName + "." + endpoint + "/" + objectName;
    }

    /**
     * 断点上传
     *
     * @param name     文件名
     * @param type     文件类型
     * @param filePath file
     * @return 文件地址
     */
    public String upload(String name, String type, String filePath) throws Throwable {
        String objectName = rename(name, type);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("text/plain");
        UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, objectName);
        uploadFileRequest.setUploadFile(filePath);
        uploadFileRequest.setTaskNum(5);
        uploadFileRequest.setEnableCheckpoint(true);
        uploadFileRequest.setObjectMetadata(meta);
        ossClient.uploadFile(uploadFileRequest);
        return "https://" + bucketName + "." + endpoint + "/" + objectName;
    }

    /**
     * 文件重命名
     *
     * @param oldName 文件名
     * @param type    文件类型
     * @return 文件新名字
     */
    private String rename(String oldName, String type) {
        Calendar.Builder builder = new Calendar.Builder();
        Calendar calendar = builder.build();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "/" + month + "/" + day + "/" + UUID.randomUUID() + "-" + oldName + "." + type;
    }

}
