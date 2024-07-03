package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:39
 */
@Mapper
public interface MultiSubjectConverter {
    MultiSubjectConverter INSTANCE = Mappers.getMapper(MultiSubjectConverter.class);


    SubjectMultiple subjectBoToPo(SubjectAnswerBo subjectAnswerBo);

    List<SubjectAnswerBo> subjectMultipleListToAnswerBO(List<SubjectMultiple> subjectMultipleList);

}
