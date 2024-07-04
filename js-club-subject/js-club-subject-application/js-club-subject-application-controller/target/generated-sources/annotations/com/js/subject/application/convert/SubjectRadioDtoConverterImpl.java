package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectRadioDto;
import com.js.subject.domain.entity.SubjectRadioBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T12:12:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SubjectRadioDtoConverterImpl implements SubjectRadioDtoConverter {

    @Override
    public SubjectRadioBo subjectRadioDtoToBo(SubjectRadioDto subjectRadioDto) {
        if ( subjectRadioDto == null ) {
            return null;
        }

        SubjectRadioBo subjectRadioBo = new SubjectRadioBo();

        subjectRadioBo.setId( subjectRadioDto.getId() );
        subjectRadioBo.setSubjectId( subjectRadioDto.getSubjectId() );
        subjectRadioBo.setOptionType( subjectRadioDto.getOptionType() );
        subjectRadioBo.setOptionContent( subjectRadioDto.getOptionContent() );
        subjectRadioBo.setIsCorrect( subjectRadioDto.getIsCorrect() );

        return subjectRadioBo;
    }
}
