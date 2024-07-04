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
    date = "2024-07-03T12:12:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SubjectInfoDtoConverterImpl implements SubjectInfoDtoConverter {

    @Override
    public SubjectInfoBo subjectInfoDtoToBo(SubjectInfoDto subjectInfoDto) {
        if ( subjectInfoDto == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setPageNo( subjectInfoDto.getPageNo() );
        subjectInfoBo.setPageSize( subjectInfoDto.getPageSize() );
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
        List<String> list2 = subjectInfoDto.getLabelName();
        if ( list2 != null ) {
            subjectInfoBo.setLabelName( new ArrayList<String>( list2 ) );
        }
        subjectInfoBo.setOptionList( subjectAnswerDtoListToSubjectAnswerBoList( subjectInfoDto.getOptionList() ) );
        subjectInfoBo.setCategoryId( subjectInfoDto.getCategoryId() );
        subjectInfoBo.setLabelId( subjectInfoDto.getLabelId() );

        return subjectInfoBo;
    }

    @Override
    public SubjectInfoDto subjectInfoBotoDto(SubjectInfoBo subjectInfoBo) {
        if ( subjectInfoBo == null ) {
            return null;
        }

        SubjectInfoDto subjectInfoDto = new SubjectInfoDto();

        subjectInfoDto.setPageNo( subjectInfoBo.getPageNo() );
        subjectInfoDto.setPageSize( subjectInfoBo.getPageSize() );
        subjectInfoDto.setId( subjectInfoBo.getId() );
        subjectInfoDto.setSubjectName( subjectInfoBo.getSubjectName() );
        subjectInfoDto.setSubjectDifficult( subjectInfoBo.getSubjectDifficult() );
        subjectInfoDto.setSettleName( subjectInfoBo.getSettleName() );
        subjectInfoDto.setSubjectType( subjectInfoBo.getSubjectType() );
        subjectInfoDto.setSubjectScore( subjectInfoBo.getSubjectScore() );
        subjectInfoDto.setSubjectParse( subjectInfoBo.getSubjectParse() );
        subjectInfoDto.setSubjectAnswer( subjectInfoBo.getSubjectAnswer() );
        List<Integer> list = subjectInfoBo.getCategoryIds();
        if ( list != null ) {
            subjectInfoDto.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<String> list1 = subjectInfoBo.getLabelName();
        if ( list1 != null ) {
            subjectInfoDto.setLabelName( new ArrayList<String>( list1 ) );
        }
        List<Integer> list2 = subjectInfoBo.getLabelIds();
        if ( list2 != null ) {
            subjectInfoDto.setLabelIds( new ArrayList<Integer>( list2 ) );
        }
        subjectInfoDto.setOptionList( subjectAnswerBoListToSubjectAnswerDtoList( subjectInfoBo.getOptionList() ) );
        subjectInfoDto.setCategoryId( subjectInfoBo.getCategoryId() );
        subjectInfoDto.setLabelId( subjectInfoBo.getLabelId() );

        return subjectInfoDto;
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

    protected SubjectAnswerDto subjectAnswerBoToSubjectAnswerDto(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectAnswerDto subjectAnswerDto = new SubjectAnswerDto();

        subjectAnswerDto.setOptionType( subjectAnswerBo.getOptionType() );
        subjectAnswerDto.setOptionContent( subjectAnswerBo.getOptionContent() );
        subjectAnswerDto.setIsCorrect( subjectAnswerBo.getIsCorrect() );

        return subjectAnswerDto;
    }

    protected List<SubjectAnswerDto> subjectAnswerBoListToSubjectAnswerDtoList(List<SubjectAnswerBo> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectAnswerDto> list1 = new ArrayList<SubjectAnswerDto>( list.size() );
        for ( SubjectAnswerBo subjectAnswerBo : list ) {
            list1.add( subjectAnswerBoToSubjectAnswerDto( subjectAnswerBo ) );
        }

        return list1;
    }
}
