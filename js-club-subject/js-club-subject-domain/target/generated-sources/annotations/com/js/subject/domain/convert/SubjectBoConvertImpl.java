package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;
import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T12:12:35+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
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

    @Override
    public List<SubjectInfoBo> SubjectPoListToBo(List<SubjectInfo> subjectInfoList) {
        if ( subjectInfoList == null ) {
            return null;
        }

        List<SubjectInfoBo> list = new ArrayList<SubjectInfoBo>( subjectInfoList.size() );
        for ( SubjectInfo subjectInfo : subjectInfoList ) {
            list.add( subjectInfoToSubjectInfoBo( subjectInfo ) );
        }

        return list;
    }

    @Override
    public SubjectInfoBo convertOptionAndInfoToBo(SubjectOptionBo subjectOptionBo, SubjectInfo subjectInfo) {
        if ( subjectOptionBo == null && subjectInfo == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        if ( subjectOptionBo != null ) {
            subjectInfoBo.setSubjectAnswer( subjectOptionBo.getSubjectAnswer() );
            List<SubjectAnswerBo> list = subjectOptionBo.getOptionList();
            if ( list != null ) {
                subjectInfoBo.setOptionList( new ArrayList<SubjectAnswerBo>( list ) );
            }
        }
        if ( subjectInfo != null ) {
            subjectInfoBo.setId( subjectInfo.getId() );
            subjectInfoBo.setSubjectName( subjectInfo.getSubjectName() );
            subjectInfoBo.setSubjectDifficult( subjectInfo.getSubjectDifficult() );
            subjectInfoBo.setSettleName( subjectInfo.getSettleName() );
            subjectInfoBo.setSubjectType( subjectInfo.getSubjectType() );
            subjectInfoBo.setSubjectScore( subjectInfo.getSubjectScore() );
            subjectInfoBo.setSubjectParse( subjectInfo.getSubjectParse() );
        }

        return subjectInfoBo;
    }

    protected SubjectInfoBo subjectInfoToSubjectInfoBo(SubjectInfo subjectInfo) {
        if ( subjectInfo == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setId( subjectInfo.getId() );
        subjectInfoBo.setSubjectName( subjectInfo.getSubjectName() );
        subjectInfoBo.setSubjectDifficult( subjectInfo.getSubjectDifficult() );
        subjectInfoBo.setSettleName( subjectInfo.getSettleName() );
        subjectInfoBo.setSubjectType( subjectInfo.getSubjectType() );
        subjectInfoBo.setSubjectScore( subjectInfo.getSubjectScore() );
        subjectInfoBo.setSubjectParse( subjectInfo.getSubjectParse() );

        return subjectInfoBo;
    }
}
