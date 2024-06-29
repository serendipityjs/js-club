package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectRadioDto;
import com.js.subject.domain.entity.SubjectRadioBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:05
 */
@Mapper
public interface SubjectRadioDtoConverter {
    SubjectRadioDtoConverter INSTANCE = Mappers.getMapper(SubjectRadioDtoConverter.class);

    SubjectRadioBo subjectRadioDtoToBo(SubjectRadioDto subjectRadioDto);
}
