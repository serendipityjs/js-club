package com.js.subject.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 17:07
 */
@Data
public class SubjectCategoryBo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类类型
     */
    private Integer categoryType;

    /**
     * 图标连接
     */
    private String imageUrl;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 题目数量
     */
    private Integer count;

    /**
     * 标签bo数量
     */
    List<SubjectLabelBo> labelBOList;
}
