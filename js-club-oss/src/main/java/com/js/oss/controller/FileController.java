package com.js.oss.controller;

import com.js.oss.entity.Result;
import com.js.oss.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/7/7 20:19
 */
@RestController
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    @Resource
//    private StorageService minioStorageServiceImpl;
    private FileService fileService;


    @RequestMapping("/testGetAllBuckets")
    public String getAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        if (CollectionUtils.isEmpty(allBucket)) {
            return "bucket is empty";
        }
        return allBucket.get(0);
    }


    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }



    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucket, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }


}

