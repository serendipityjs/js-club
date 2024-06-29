package com.js.subject.domain.service;

import com.js.subject.domain.entity.SubjectLabelBo;

import java.util.List;

/**
 * 题目标签领域服务
 *
 * @author jiaoshuai
 * @date 2024/6/27 10:32
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     */
    Boolean add(SubjectLabelBo subjectLabelBo);

    /**
     * 修改标签
     */
    Boolean update(SubjectLabelBo subjectLabelBo);

    /**
     * 删除标签
     */
    Boolean delete(SubjectLabelBo subjectLabelBo);

    /**
     * 查询分类下标签
     */
    List<SubjectLabelBo> queryLabelByCategoryId(SubjectLabelBo subjectLabelBo);
}
