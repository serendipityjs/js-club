package com.js.subject.domain.service;

import com.js.subject.domain.entity.SubjectInfoBo;

/**
 * 题目领域服务
 *
 * @author jiaoshuai
 * @date 2024/6/29 10:18
 */
public interface SubjectDomainService {

    /**
     * 新增标签
     */
    void add(SubjectInfoBo subjectInfoBo);
}
