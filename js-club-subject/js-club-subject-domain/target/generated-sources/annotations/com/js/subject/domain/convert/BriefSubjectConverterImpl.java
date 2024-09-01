package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectBrief;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T10:33:49+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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

    @Override
    public SubjectBrief subjectInfoBoToBrief(SubjectInfoBo subjectInfoBo) {
        if ( subjectInfoBo == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        subjectBrief.setId( subjectInfoBo.getId() );
        subjectBrief.setSubjectAnswer( subjectInfoBo.getSubjectAnswer() );

        return subjectBrief;
    }
}
