package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectLabelBo;
import com.js.subject.infrastructure.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:39
 */
@Mapper
public interface SubjectLabelBoConvert {
    SubjectLabelBoConvert INSTANCE = Mappers.getMapper(SubjectLabelBoConvert.class);

    SubjectLabel convertBoToPo(SubjectLabelBo subjectLabelBo);

    List<SubjectLabelBo> convertPoToBOList(List<SubjectLabel> subjectLabels);

}
