package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectAnswerDto;
import com.js.subject.domain.entity.SubjectAnswerBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T11:08:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
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
