package com.js.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签DTO
 *
 * @author jiaoshuai
 * @since 2024-06-27 10:04:54
 */
@Data
public class SubjectLabelDto implements Serializable {
    private static final long serialVersionUID = -45945499448778175L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;
}

