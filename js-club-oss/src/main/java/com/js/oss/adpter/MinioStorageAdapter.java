package com.js.oss.adpter;

import com.js.oss.entity.FileInfo;
import com.js.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/7/7 20:44
 */
public class MinioStorageAdapter implements StorageAdapter {

    /**
     * minioUrl
     */
    @Value("${minio.url}")
    private String url;


    @Resource
    MinioUtil minioUtil;

    @Override
    @SneakyThrows
    public void createBucket(String bucket) {
        minioUtil.createBucket(bucket);
    }


    /**
     * 上传文件
     *
     * @param uploadFile
     * @param bucket
     * @param objectName
     */
    @Override
    @SneakyThrows
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {
        minioUtil.createBucket(bucket);
        if (objectName != null) {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucket, objectName + "/" + uploadFile.getOriginalFilename());
        } else {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucket, uploadFile.getOriginalFilename());
        }
    }

    /**
     * 获取文件路径
     *
     * @param bucket
     * @param objectName
     * @return
     */
    @Override
    @SneakyThrows
    public String getUrl(String bucket, String objectName) {
        return url + "/" + bucket + "/" + objectName;
    }



    @Override
    @SneakyThrows
    public List<String> getAllBucket() {
        return minioUtil.getAllBucket();
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getAllFile(String bucket) {
        return minioUtil.getAllFile(bucket);
    }

    @Override
    @SneakyThrows
    public InputStream downLoad(String bucket, String objectName) {
        return minioUtil.downLoad(bucket, objectName);
    }

    @Override
    @SneakyThrows
    public void deleteBucket(String bucket) {
        minioUtil.deleteBucket(bucket);
    }

    @Override
    @SneakyThrows
    public void deleteObject(String bucket, String objectName) {
        minioUtil.deleteObject(bucket, objectName);
    }


}
