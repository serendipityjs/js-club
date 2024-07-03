package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.infrastructure.basic.entity.SubjectJudge;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T11:21:50+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class JudgeSubjectConverterImpl implements JudgeSubjectConverter {

    @Override
    public SubjectJudge subjectBoToPo(SubjectAnswerBo subjectAnswerBo) {
        if ( subjectAnswerBo == null ) {
            return null;
        }

        SubjectJudge subjectJudge = new SubjectJudge();

        if ( subjectAnswerBo.getIsCorrect() != null ) {
            subjectJudge.setIsCorrect( Integer.parseInt( subjectAnswerBo.getIsCorrect() ) );
        }

        return subjectJudge;
    }

    @Override
    public List<SubjectAnswerBo> subjectJudgeListTOAnswerBo(List<SubjectJudge> subjectJudgeList) {
        if ( subjectJudgeList == null ) {
            return null;
        }

        List<SubjectAnswerBo> list = new ArrayList<SubjectAnswerBo>( subjectJudgeList.size() );
        for ( SubjectJudge subjectJudge : subjectJudgeList ) {
            list.add( subjectJudgeToSubjectAnswerBo( subjectJudge ) );
        }

        return list;
    }

    protected SubjectAnswerBo subjectJudgeToSubjectAnswerBo(SubjectJudge subjectJudge) {
        if ( subjectJudge == null ) {
            return null;
        }

        SubjectAnswerBo subjectAnswerBo = new SubjectAnswerBo();

        if ( subjectJudge.getIsCorrect() != null ) {
            subjectAnswerBo.setIsCorrect( String.valueOf( subjectJudge.getIsCorrect() ) );
        }

        return subjectAnswerBo;
    }
}
