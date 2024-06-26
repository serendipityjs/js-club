package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectCategoryBo;
import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 18:24
 */
@Mapper
public interface SubjectCategoryConvert {
    SubjectCategoryConvert INSTANCE = Mappers.getMapper(SubjectCategoryConvert.class);

    SubjectCategory convertToCategory(SubjectCategoryBo subjectCategoryBo);

    List<SubjectCategoryBo> convertToBoList(List<SubjectCategory> subjectCategories);

}
