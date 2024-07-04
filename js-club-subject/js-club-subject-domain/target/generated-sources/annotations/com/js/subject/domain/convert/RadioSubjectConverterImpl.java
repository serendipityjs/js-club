package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectRadio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T12:12:35+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class RadioSubjectConverterImpl implements RadioSubjectConverter {

    @Override
    public SubjectRadio subjectBoToPo(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectRadio subjectRadio = new SubjectRadio();

        if ( subjectAnswerBo.getOptionType() != null ) {
            subjectRadio.setOptionType( Integer.parseInt( subjectAnswerBo.getOptionType() ) );
        }
        subjectRadio.setOptionContent( subjectAnswerBo.getOptionContent() );
        if ( subjectAnswerBo.getIsCorrect() != null ) {
            subjectRadio.setIsCorrect( Integer.parseInt( subjectAnswerBo.getIsCorrect() ) );
        }

        return subjectRadio;
    }

    @Override
    public List<SubjectAnswerBo> subjectRadioListToAnswer(List<SubjectRadio> subjectRadioList) {
        if ( subjectRadioList == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( subjectRadioList.size() );
        for ( SubjectRadio subjectRadio : subjectRadioList ) {
            list.add( subjectRadioToSubjectAnswerBo( subjectRadio ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectRadioToSubjectAnswerBo(SubjectRadio subjectRadio) {
        if ( subjectRadio == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        if ( subjectRadio.getOptionType() != null ) {
            subjectAnswerBo.setOptionType( String.valueOf( subjectRadio.getOptionType() ) );
        }
        subjectAnswerBo.setOptionContent( subjectRadio.getOptionContent() );
        if ( subjectRadio.getIsCorrect() != null ) {
            subjectAnswerBo.setIsCorrect( String.valueOf( subjectRadio.getIsCorrect() ) );
        }

        return subjectAnswerBo;
    }
}
