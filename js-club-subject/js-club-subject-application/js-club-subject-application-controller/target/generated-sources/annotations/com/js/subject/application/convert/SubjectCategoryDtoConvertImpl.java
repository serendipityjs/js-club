package com.js.subject.application.convert;

import com.js.subject.application.dto.SubjectCategoryDto;
import com.js.subject.domain.entity.SubjectCategoryBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T10:33:51+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class SubjectCategoryDtoConvertImpl implements SubjectCategoryDtoConvert {

    @Override
    public SubjectCategoryBo convertDtoToBo(SubjectCategoryDto subjectCategoryDto) {
        if ( subjectCategoryDto == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setId( subjectCategoryDto.getId() );
        subjectCategoryBo.setCategoryName( subjectCategoryDto.getCategoryName() );
        subjectCategoryBo.setCategoryType( subjectCategoryDto.getCategoryType() );
        subjectCategoryBo.setImageUrl( subjectCategoryDto.getImageUrl() );
        subjectCategoryBo.setParentId( subjectCategoryDto.getParentId() );
        subjectCategoryBo.setCount( subjectCategoryDto.getCount() );

        return subjectCategoryBo;
    }

    @Override
    public List<SubjectCategoryDto> convertBoListToDtoList(List<SubjectCategoryBo> subjectCategoryBos) {
        if ( subjectCategoryBos == null ) {
            return null;
        }

        List<SubjectCategoryDto> list = new ArrayList<SubjectCategoryDto>( subjectCategoryBos.size() );
        for ( SubjectCategoryBo subjectCategoryBo : subjectCategoryBos ) {
            list.add( convertBoToCategoryDTO( subjectCategoryBo ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryDto convertBoToCategoryDTO(SubjectCategoryBo bo) {
        if ( bo == null ) {
            return null;
        }

        SubjectCategoryDto subjectCategoryDto = new SubjectCategoryDto();

        subjectCategoryDto.setId( bo.getId() );
        subjectCategoryDto.setCategoryName( bo.getCategoryName() );
        subjectCategoryDto.setCategoryType( bo.getCategoryType() );
        subjectCategoryDto.setImageUrl( bo.getImageUrl() );
        subjectCategoryDto.setParentId( bo.getParentId() );
        subjectCategoryDto.setCount( bo.getCount() );

        return subjectCategoryDto;
    }
}
