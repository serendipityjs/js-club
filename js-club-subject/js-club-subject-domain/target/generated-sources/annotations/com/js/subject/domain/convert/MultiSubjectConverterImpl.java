package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectMultiple;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T22:16:15+0800",
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
}
