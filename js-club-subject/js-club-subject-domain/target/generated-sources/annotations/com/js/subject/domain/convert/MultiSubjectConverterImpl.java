package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectMultiple;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T11:08:30+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class MultiSubjectConverterImpl implements MultiSubjectConverter {

    @Override
    public SubjectMultiple subjectBoToPo(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectMultiple subjectMultiple = new SubjectMultiple();

        if ( subjectAnswerBo.getOptionType() != null ) {
            subjectMultiple.setOptionType( Long.parseLong( subjectAnswerBo.getOptionType() ) );
        }
        subjectMultiple.setOptionContent( subjectAnswerBo.getOptionContent() );
        if ( subjectAnswerBo.getIsCorrect() != null ) {
            subjectMultiple.setIsCorrect( Integer.parseInt( subjectAnswerBo.getIsCorrect() ) );
        }

        return subjectMultiple;
    }

    @Override
    public List<SubjectAnswerBo> subjectMultipleListToAnswerBO(List<SubjectMultiple> subjectMultipleList) {
        if ( subjectMultipleList == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( subjectMultipleList.size() );
        for ( SubjectMultiple subjectMultiple : subjectMultipleList ) {
            list.add( subjectMultipleToSubjectAnswerBo( subjectMultiple ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectMultipleToSubjectAnswerBo(SubjectMultiple subjectMultiple) {
        if ( subjectMultiple == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        if ( subjectMultiple.getOptionType() != null ) {
            subjectAnswerBo.setOptionType( String.valueOf( subjectMultiple.getOptionType() ) );
        }
        subjectAnswerBo.setOptionContent( subjectMultiple.getOptionContent() );
        if ( subjectMultiple.getIsCorrect() != null ) {
            subjectAnswerBo.setIsCorrect( String.valueOf( subjectMultiple.getIsCorrect() ) );
        }

        return subjectAnswerBo;
    }
}
