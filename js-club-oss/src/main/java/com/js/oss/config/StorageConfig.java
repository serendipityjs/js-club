package com.js.oss.config;

import com.js.oss.adpter.AliyunStorageAdapter;
import com.js.oss.adpter.MinioStorageAdapter;
import com.js.oss.adpter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiaoshuai
 * @date 2024/7/9 21:43
 */
@Configuration
@RefreshScope
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliyunStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件处理器");
        }
    }

}
