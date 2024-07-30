package com.js.oss.adpter;

import com.js.oss.entity.FileInfo;
import com.js.oss.util.MinioUtil;
import lombok.SneakyThrows;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/7/7 20:44
 */
public class MinioStorageAdapter implements StorageAdapter {

    @Resource
    MinioUtil minioUtil;

    @Override
    @SneakyThrows
    public void createBucket(String bucket) {
        minioUtil.createBucket(bucket);
    }

    @Override
    @SneakyThrows
    public void uploadFile(InputStream inputStream, String bucket, String objectName) {
        minioUtil.uploadFile(inputStream, bucket, objectName);
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
