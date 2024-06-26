package com.js.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.domain.convert.SubjectCategoryConvert;
import com.js.subject.domain.entity.SubjectCategoryBo;
import com.js.subject.domain.service.SubjectCategoryDomainService;
import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import com.js.subject.infrastructure.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 16:49
 */

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    public void add(SubjectCategoryBo subjectCategoryBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.add.subjectCategoryBo:{}", JSON.toJSONString(subjectCategoryBo));
        }
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        List<SubjectCategory> subjectCategories = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBo> subjectCategoryBos = SubjectCategoryConvert.INSTANCE.convertToBoList(subjectCategories);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.queryCategory.subjectCategoryBos:{}", JSON.toJSON(subjectCategoryBos));
        }
        return subjectCategoryBos;
    }

    @Override
    public Boolean update(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
