package com.js.subject.domain.convert;

import com.js.subject.domain.entity.SubjectCategoryBo;
import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T10:33:49+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class SubjectCategoryBoConvertImpl implements SubjectCategoryBoConvert {

    @Override
    public SubjectCategory convertToCategory(SubjectCategoryBo subjectCategoryBo) {
        if ( subjectCategoryBo == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setId( subjectCategoryBo.getId() );
        subjectCategory.setCategoryName( subjectCategoryBo.getCategoryName() );
        subjectCategory.setCategoryType( subjectCategoryBo.getCategoryType() );
        subjectCategory.setImageUrl( subjectCategoryBo.getImageUrl() );
        subjectCategory.setParentId( subjectCategoryBo.getParentId() );

        return subjectCategory;
    }

    @Override
    public List<SubjectCategoryBo> convertToBoList(List<SubjectCategory> subjectCategories) {
        if ( subjectCategories == null ) {
            return null;
        }

        List<SubjectCategoryBo> list = new ArrayList<SubjectCategoryBo>( subjectCategories.size() );
        for ( SubjectCategory subjectCategory : subjectCategories ) {
            list.add( subjectCategoryToSubjectCategoryBo( subjectCategory ) );
        }

        return list;
    }

    protected SubjectCategoryBo subjectCategoryToSubjectCategoryBo(SubjectCategory subjectCategory) {
        if ( subjectCategory == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setId( subjectCategory.getId() );
        subjectCategoryBo.setCategoryName( subjectCategory.getCategoryName() );
        subjectCategoryBo.setCategoryType( subjectCategory.getCategoryType() );
        subjectCategoryBo.setImageUrl( subjectCategory.getImageUrl() );
        subjectCategoryBo.setParentId( subjectCategory.getParentId() );

        return subjectCategoryBo;
    }
}
