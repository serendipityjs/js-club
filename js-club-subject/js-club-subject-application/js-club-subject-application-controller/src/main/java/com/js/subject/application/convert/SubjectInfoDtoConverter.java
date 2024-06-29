package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectInfoDto;
import com.js.subject.domain.entity.SubjectInfoBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:03
 */
@Mapper
public interface SubjectInfoDtoConverter {
    SubjectInfoDtoConverter INSTANCE= Mappers.getMapper(SubjectInfoDtoConverter.class);

    SubjectInfoBo subjectInfoDtoToBo(SubjectInfoDto subjectInfoDto);
}
