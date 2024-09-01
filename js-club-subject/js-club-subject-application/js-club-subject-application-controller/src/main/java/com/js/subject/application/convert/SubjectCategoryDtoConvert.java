package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectCategoryDto;
import com.js.subject.domain.entity.SubjectCategoryBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 21:25
 */
@Mapper
public interface SubjectCategoryDtoConvert {
    SubjectCategoryDtoConvert INSTANCE = Mappers.getMapper(SubjectCategoryDtoConvert.class);

    SubjectCategoryBo convertDtoToBo(SubjectCategoryDto subjectCategoryDto);

    List<SubjectCategoryDto> convertBoListToDtoList(List<SubjectCategoryBo> subjectCategoryBos);

    SubjectCategoryDto convertBoToCategoryDTO(SubjectCategoryBo bo);
}
