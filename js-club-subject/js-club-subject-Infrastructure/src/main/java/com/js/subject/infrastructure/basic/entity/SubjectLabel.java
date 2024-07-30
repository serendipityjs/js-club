package com.js.subject.infrastructure.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-06-27 10:04:54
 */
@Data
public class SubjectLabel implements Serializable {
    private static final long serialVersionUID = -45945499448778175L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 标签分类id
     */
    private Long categoryId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;


    private Integer isDeleted;
}

