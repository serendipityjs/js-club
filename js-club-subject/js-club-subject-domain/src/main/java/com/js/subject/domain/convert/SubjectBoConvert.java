package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:39
 */
@Mapper
public interface SubjectBoConvert {
    SubjectBoConvert INSTANCE = Mappers.getMapper(SubjectBoConvert.class);

    SubjectInfo convertBoToPo(SubjectInfoBo subjectInfoBo);


}
