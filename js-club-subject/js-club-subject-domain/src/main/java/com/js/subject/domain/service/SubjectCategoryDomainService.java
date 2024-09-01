package com.js.subject.domain.service;

import com.js.subject.domain.entity.SubjectCategoryBo;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 16:49
 */
public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询岗位大类
     */
    List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo);

    Boolean update(SubjectCategoryBo subjectCategoryBo);

    Boolean delete(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询分类及标签
     *
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBo> queryCategoryAndLabel(SubjectCategoryBo subjectCategoryBO);
}
