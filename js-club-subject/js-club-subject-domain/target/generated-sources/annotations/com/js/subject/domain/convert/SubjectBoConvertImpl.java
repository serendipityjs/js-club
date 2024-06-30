package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T22:16:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class SubjectBoConvertImpl implements SubjectBoConvert {

    @Override
    public SubjectInfo convertBoToPo(SubjectInfoBo subjectInfoBo) {
        if ( subjectInfoBo == null ) {
            return null;
        }

        SubjectInfo subjectInfo = new SubjectInfo();

        subjectInfo.setId( subjectInfoBo.getId() );
        subjectInfo.setSubjectName( subjectInfoBo.getSubjectName() );
        subjectInfo.setSubjectDifficult( subjectInfoBo.getSubjectDifficult() );
        subjectInfo.setSettleName( subjectInfoBo.getSettleName() );
        subjectInfo.setSubjectType( subjectInfoBo.getSubjectType() );
        subjectInfo.setSubjectScore( subjectInfoBo.getSubjectScore() );
        subjectInfo.setSubjectParse( subjectInfoBo.getSubjectParse() );

        return subjectInfo;
    }
}
