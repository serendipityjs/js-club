package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectRadio;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T22:16:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
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
}
