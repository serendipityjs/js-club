package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.convert.BriefSubjectConverter;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectBrief;
import com.js.subject.infrastructure.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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
        //简单题目的插入
        List<SubjectBrief> subjectBriefLinkedList = new LinkedList<>();
        List<SubjectAnswerBo> optionList = subjectInfoBo.getOptionList();

        if (CollectionUtils.isEmpty(optionList)) {
            return;
        }

        optionList.forEach(option -> {
            SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.subjectBoToPo(option);
            subjectBrief.setSubjectId(subjectInfoBo.getId());
            subjectBriefLinkedList.add(subjectBrief);
        });

        subjectBriefService.batchInset(subjectBriefLinkedList);

    }
}