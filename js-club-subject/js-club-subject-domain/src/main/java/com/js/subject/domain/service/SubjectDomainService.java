package com.js.subject.domain.service;

import com.js.subject.comm.entity.PageResult;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectInfoEs;

/**
 * 题目领域服务
 *
 * @author jiaoshuai
 * @date 2024/6/29 10:18
 */
public interface SubjectDomainService {

    /**
     * 新增题目
     */
    void add(SubjectInfoBo subjectInfoBo);

    /**
     * 题目分页查询
     *
     * @param subjectInfoBo
     * @return
     */
    PageResult<SubjectInfoBo> queryPage(SubjectInfoBo subjectInfoBo);

    /**
     * 查询题目详情
     *
     * @param subjectInfoBo
     * @return
     */
    SubjectInfoBo getSubjectInfo(SubjectInfoBo subjectInfoBo);

    /**
     * 全文检索
     *
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBo subjectInfoBO);
}
