package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectBrief;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T22:16:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class BriefSubjectConverterImpl implements BriefSubjectConverter {

    @Override
    public SubjectBrief subjectBoToPo(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        return subjectBrief;
    }
}
