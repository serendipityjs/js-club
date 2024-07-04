package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectLabelDto;
import com.js.subject.domain.entity.SubjectLabelBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T12:12:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SubjectLabelDtoConvertImpl implements SubjectLabelDtoConvert {

    @Override
    public SubjectLabelBo subjectLabelDtoToBO(SubjectLabelDto subjectLabelDto) {
        if ( subjectLabelDto == null ) {
            return null;
        }

        SubjectLabelBo subjectLabelBo = new SubjectLabelBo();

        subjectLabelBo.setId( subjectLabelDto.getId() );
        subjectLabelBo.setCategoryId( subjectLabelDto.getCategoryId() );
        subjectLabelBo.setLabelName( subjectLabelDto.getLabelName() );
        subjectLabelBo.setSortNum( subjectLabelDto.getSortNum() );

        return subjectLabelBo;
    }

    @Override
    public List<SubjectLabelDto> subjectLabelBoListToDto(List<SubjectLabelBo> subjectLabelBos) {
        if ( subjectLabelBos == null ) {
            return null;
        }

        List<SubjectLabelDto> list = new ArrayList<SubjectLabelDto>( subjectLabelBos.size() );
        for ( SubjectLabelBo subjectLabelBo : subjectLabelBos ) {
            list.add( subjectLabelBoToSubjectLabelDto( subjectLabelBo ) );
        }

        return list;
    }

    protected SubjectLabelDto subjectLabelBoToSubjectLabelDto(SubjectLabelBo subjectLabelBo) {
        if ( subjectLabelBo == null ) {
            return null;
        }

        SubjectLabelDto subjectLabelDto = new SubjectLabelDto();

        subjectLabelDto.setId( subjectLabelBo.getId() );
        subjectLabelDto.setCategoryId( subjectLabelBo.getCategoryId() );
        subjectLabelDto.setLabelName( subjectLabelBo.getLabelName() );
        subjectLabelDto.setSortNum( subjectLabelBo.getSortNum() );

        return subjectLabelDto;
    }
}
