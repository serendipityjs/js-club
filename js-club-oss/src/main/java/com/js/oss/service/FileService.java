package com.js.oss.service;

import com.js.oss.adpter.StorageAdapter;
import org.springframework.stereotype.Service;

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
}
