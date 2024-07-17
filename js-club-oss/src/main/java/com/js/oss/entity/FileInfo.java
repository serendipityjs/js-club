package com.js.oss.entity;

/**
 * @author jiaoshuai
 * @date 2024/7/7 10:52
 */
public class FileInfo {
    private String fileName;

    private Boolean directoryFlag;

    private String etag;

    public String getFileName() {
        return fileName;
    }

    public Boolean getDirectoryFlag() {
        return directoryFlag;
    }

    public void setDirectoryFlag(Boolean directoryFlag) {
        this.directoryFlag = directoryFlag;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
