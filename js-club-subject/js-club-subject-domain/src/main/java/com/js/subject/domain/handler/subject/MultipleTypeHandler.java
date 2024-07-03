package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.convert.MultiSubjectConverter;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;
import com.js.subject.infrastructure.basic.entity.SubjectMultiple;
import com.js.subject.infrastructure.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:45
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        //多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        List<SubjectAnswerBo> optionList = subjectInfoBo.getOptionList();

        if (CollectionUtils.isEmpty(optionList)) {
            return;
        }

        optionList.forEach(option -> {
            SubjectMultiple subjectMultiple = MultiSubjectConverter.INSTANCE.subjectBoToPo(option);
            subjectMultiple.setSubjectId(subjectInfoBo.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });

        subjectMultipleService.batchInset(subjectMultipleList);

    }

    @Override
    public SubjectOptionBo query(Long subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBo> subjectAnswerBOList = MultiSubjectConverter.INSTANCE.subjectMultipleListToAnswerBO(result);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }


}