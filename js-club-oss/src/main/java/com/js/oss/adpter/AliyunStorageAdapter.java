package com.js.oss.adpter;

import com.js.oss.entity.FileInfo;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/7/8 8:44
 */
public class AliyunStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucket) {

    }

    @Override
    public void uploadFile(InputStream inputStream, String bucket, String objectName) {

    }

    @Override
    public List<String> getAllBucket() {
        //模拟实现阿里云服务，验证调用的是哪个服务
        List<String> list = new LinkedList<>();
        list.add("aliyun");
        return list;
    }

    @Override
    public List<FileInfo> getAllFile(String bucket) {
        return null;
    }

    @Override
    public InputStream downLoad(String bucket, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucket) {

    }

    @Override
    public void deleteObject(String bucket, String objectName) {

    }
}
