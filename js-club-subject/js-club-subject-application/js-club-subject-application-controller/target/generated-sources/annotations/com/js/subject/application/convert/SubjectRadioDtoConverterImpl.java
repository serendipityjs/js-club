package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectRadioDto;
import com.js.subject.domain.entity.SubjectRadioBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T11:08:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
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
