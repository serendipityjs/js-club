package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.convert.RadioSubjectConverter;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectRadio;
import com.js.subject.infrastructure.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:45
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {
    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        List<SubjectAnswerBo> optionList = subjectInfoBo.getOptionList();

        if (CollectionUtils.isEmpty(optionList)) {
            return;
        }

        optionList.forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.subjectBoToPo(option);
            subjectRadio.setSubjectId(subjectInfoBo.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }
}
