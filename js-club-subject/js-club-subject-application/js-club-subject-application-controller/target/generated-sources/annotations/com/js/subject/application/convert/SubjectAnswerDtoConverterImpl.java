package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectAnswerDto;
import com.js.subject.domain.entity.SubjectAnswerBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T12:12:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SubjectAnswerDtoConverterImpl implements SubjectAnswerDtoConverter {

    @Override
    public List<SubjectAnswerBo> subjectAnswerDtoListToBoList(List<SubjectAnswerDto> subjectAnswerDto) {
        if ( subjectAnswerDto == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( subjectAnswerDto.size() );
        for ( SubjectAnswerDto subjectAnswerDto1 : subjectAnswerDto ) {
            list.add( subjectAnswerDtoToSubjectAnswerBo( subjectAnswerDto1 ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectAnswerDtoToSubjectAnswerBo(SubjectAnswerDto subjectAnswerDto) {
        if ( subjectAnswerDto == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        subjectAnswerBo.setOptionType( subjectAnswerDto.getOptionType() );
        subjectAnswerBo.setOptionContent( subjectAnswerDto.getOptionContent() );
        subjectAnswerBo.setIsCorrect( subjectAnswerDto.getIsCorrect() );

        return subjectAnswerBo;
    }
}
