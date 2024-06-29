package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectLabelDto;
import com.js.subject.domain.entity.SubjectLabelBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:25
 */
@Mapper
public interface SubjectLabelDtoConvert {
    SubjectLabelDtoConvert INSTANCE = Mappers.getMapper(SubjectLabelDtoConvert.class);

    SubjectLabelBo subjectLabelDtoToBO(SubjectLabelDto subjectLabelDto);

    List<SubjectLabelDto> subjectLabelBoListToDto(List<SubjectLabelBo> subjectLabelBos);
}
