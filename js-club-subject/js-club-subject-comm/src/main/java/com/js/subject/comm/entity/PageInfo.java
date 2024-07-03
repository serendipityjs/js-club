package com.js.subject.comm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求实体
 *
 * @author jiaoshuai
 * @date 2024/6/30 10:27
 */
@Data
public class PageInfo implements Serializable {
    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        if (null == pageNo || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (null == pageSize || pageSize < 1) {
            return 20;
        }
        return pageSize;
    }

}
