package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:39
 */
@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);


    SubjectRadio subjectBoToPo(SubjectAnswerBo subjectAnswerBo);

    List<SubjectAnswerBo> subjectRadioListToAnswer(List<SubjectRadio> subjectRadioList);

}
