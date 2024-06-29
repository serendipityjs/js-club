package com.js.subject.infrastructure.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * 题目分类关系表(SubjectMapping)实体类
 *
 * @author makejava
 * @since 2024-06-27 11:19:09
 */
@Data
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = -54217545530147779L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签id
     */
    private Long labelId;

    /**
     * 创建人
     */
    private String createdBy;


    /**
     * 创建时间
     */
    private Date createdTime;


    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;


    private Integer isDeleted;


}

