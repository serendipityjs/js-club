package com.js.oss.adpter;

import com.js.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 文件存储设配器
 *
 * @author jiaoshuai
 * @date 2024/7/7 20:34
 */
public interface StorageAdapter {
    /**
     * 创建bucket桶
     */
    void createBucket(String bucket);

    /**
     * 上传文件
     */
    void uploadFile(MultipartFile uploadFile, String bucket, String objectName);

    /**
     * 获取url
     *
     * @param bucket
     * @param objectName
     * @return
     */
    String getUrl(String bucket, String objectName);

    /**
     * 列出所有桶
     *
     * @return
     * @throws Exception
     */
    List<String> getAllBucket();

    /**
     * 列出当前桶及文件
     *
     * @param bucket
     * @return
     * @throws Exception
     */
    List<FileInfo> getAllFile(String bucket);

    /**
     * 下载文件
     *
     * @param bucket
     * @param objectName
     * @return
     */
    InputStream downLoad(String bucket, String objectName);

    /**
     * 删除桶
     *
     * @param bucket
     * @throws Exception
     */
    void deleteBucket(String bucket);

    /**
     * 删除文件
     *
     * @param bucket
     * @param objectName
     * @throws Exception
     */
    void deleteObject(String bucket, String objectName);
}
