package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectAnswerDto;
import com.js.subject.domain.entity.SubjectAnswerBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:05
 */
@Mapper
public interface SubjectAnswerDtoConverter {
    SubjectAnswerDtoConverter INSTANCE = Mappers.getMapper(SubjectAnswerDtoConverter.class);

    List<SubjectAnswerBo> subjectAnswerDtoListToBoList(List<SubjectAnswerDto> subjectAnswerDto);
}
