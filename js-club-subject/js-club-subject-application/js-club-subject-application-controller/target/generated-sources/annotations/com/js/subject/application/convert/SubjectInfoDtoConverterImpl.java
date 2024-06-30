package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectAnswerDto;
import com.js.subject.application.dto.SubjectInfoDto;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T22:16:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class SubjectInfoDtoConverterImpl implements SubjectInfoDtoConverter {

    @Override
    public SubjectInfoBo subjectInfoDtoToBo(SubjectInfoDto subjectInfoDto) {
        if ( subjectInfoDto == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setId( subjectInfoDto.getId() );
        subjectInfoBo.setSubjectName( subjectInfoDto.getSubjectName() );
        subjectInfoBo.setSubjectDifficult( subjectInfoDto.getSubjectDifficult() );
        subjectInfoBo.setSettleName( subjectInfoDto.getSettleName() );
        subjectInfoBo.setSubjectType( subjectInfoDto.getSubjectType() );
        subjectInfoBo.setSubjectScore( subjectInfoDto.getSubjectScore() );
        subjectInfoBo.setSubjectParse( subjectInfoDto.getSubjectParse() );
        subjectInfoBo.setSubjectAnswer( subjectInfoDto.getSubjectAnswer() );
        List<Integer> list = subjectInfoDto.getCategoryIds();
        if ( list != null ) {
            subjectInfoBo.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = subjectInfoDto.getLabelIds();
        if ( list1 != null ) {
            subjectInfoBo.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        subjectInfoBo.setOptionList( subjectAnswerDtoListToSubjectAnswerBoList( subjectInfoDto.getOptionList() ) );

        return subjectInfoBo;
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

    protected List<SubjectAnswerBo> subjectAnswerDtoListToSubjectAnswerBoList(List<SubjectAnswerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectAnswerBo> list1 = new ArrayList<SubjectAnswerBo>( list.size() );
        for ( SubjectAnswerDto subjectAnswerDto : list ) {
            list1.add( subjectAnswerDtoToSubjectAnswerBo( subjectAnswerDto ) );
        }

        return list1;
    }
}
