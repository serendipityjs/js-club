package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectMultiple;
import com.js.subject.infrastructure.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:39
 */
@Mapper
public interface MultiSubjectConverter {
    MultiSubjectConverter INSTANCE = Mappers.getMapper(MultiSubjectConverter.class);


    SubjectMultiple subjectBoToPo(SubjectAnswerBo subjectAnswerBo);

}
