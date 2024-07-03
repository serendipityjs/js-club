package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.convert.BriefSubjectConverter;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;
import com.js.subject.infrastructure.basic.entity.SubjectBrief;
import com.js.subject.infrastructure.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题目的策略类
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:45
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.subjectInfoBoToBrief(subjectInfoBo);
        subjectBrief.setSubjectId(subjectInfoBo.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBo query(Long subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;

    }
}