package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectLabelBo;
import com.js.subject.infrastructure.basic.entity.SubjectLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T10:33:49+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class SubjectLabelBoConvertImpl implements SubjectLabelBoConvert {

    @Override
    public SubjectLabel convertBoToPo(SubjectLabelBo subjectLabelBo) {
        if ( subjectLabelBo == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( subjectLabelBo.getId() );
        subjectLabel.setLabelName( subjectLabelBo.getLabelName() );
        subjectLabel.setSortNum( subjectLabelBo.getSortNum() );
        subjectLabel.setCategoryId( subjectLabelBo.getCategoryId() );

        return subjectLabel;
    }

    @Override
    public List<SubjectLabelBo> convertPoToBOList(List<SubjectLabel> subjectLabels) {
        if ( subjectLabels == null ) {
            return null;
        }

        List<SubjectLabelBo> list = new ArrayList<SubjectLabelBo>( subjectLabels.size() );
        for ( SubjectLabel subjectLabel : subjectLabels ) {
            list.add( subjectLabelToSubjectLabelBo( subjectLabel ) );
        }

        return list;
    }

    protected SubjectLabelBo subjectLabelToSubjectLabelBo(SubjectLabel subjectLabel) {
        if ( subjectLabel == null ) {
            return null;
        }

        SubjectLabelBo subjectLabelBo = new SubjectLabelBo();

        subjectLabelBo.setId( subjectLabel.getId() );
        subjectLabelBo.setCategoryId( subjectLabel.getCategoryId() );
        subjectLabelBo.setLabelName( subjectLabel.getLabelName() );
        subjectLabelBo.setSortNum( subjectLabel.getSortNum() );

        return subjectLabelBo;
    }
}
