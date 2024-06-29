package com.js.subject.infrastructure.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 简答题(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2024-06-28 10:16:45
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = -44603938473736573L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目答案
     */
    private String subjectAnswer;

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

