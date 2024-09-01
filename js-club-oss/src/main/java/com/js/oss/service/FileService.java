package com.js.oss.service;

import com.js.oss.adpter.StorageAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/7/9 21:41
 */
@Service
public class FileService {
    private final StorageAdapter storageAdapter;

    public FileService(StorageAdapter storageAdapter) {
        this.storageAdapter = storageAdapter;
    }

    public List<String> getAllBucket() {
        return storageAdapter.getAllBucket();
    }

    /**
     * 获取文件路径
     */
    public String getUrl(String bucketName,String objectName) {
        return storageAdapter.getUrl(bucketName,objectName);
    }

    /**
     * 上传文件
     */
    public String uploadFile(MultipartFile uploadFile, String bucket, String objectName){
        storageAdapter.uploadFile(uploadFile,bucket,objectName);
        objectName = objectName + "/" + uploadFile.getOriginalFilename();
        return storageAdapter.getUrl(bucket, objectName);
    }

}
