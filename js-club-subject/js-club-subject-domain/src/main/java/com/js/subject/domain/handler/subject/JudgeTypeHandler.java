package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.convert.JudgeSubjectConverter;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;
import com.js.subject.infrastructure.basic.entity.SubjectJudge;
import com.js.subject.infrastructure.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断题目的策略类
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:45
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        //判断题目的插入
        List<SubjectJudge> subjectJudgeLinkedList = new LinkedList<>();
        List<SubjectAnswerBo> optionList = subjectInfoBo.getOptionList();

        if (CollectionUtils.isEmpty(optionList)) {
            return;
        }

        optionList.forEach(option -> {
            SubjectJudge subjectJudge = JudgeSubjectConverter.INSTANCE.subjectBoToPo(option);
            subjectJudge.setSubjectId(subjectInfoBo.getId());
            subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectJudgeLinkedList.add(subjectJudge);
        });

        subjectJudgeService.batchInset(subjectJudgeLinkedList);

    }

    @Override
    public SubjectOptionBo query(Long subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBo> subjectAnswerBOList = JudgeSubjectConverter.INSTANCE.subjectJudgeListTOAnswerBo(result);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}