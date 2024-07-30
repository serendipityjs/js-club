package com.js.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.js.subject.comm.enums.CategoryTypeEnum;
import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.domain.convert.SubjectLabelBoConvert;
import com.js.subject.domain.entity.SubjectLabelBo;
import com.js.subject.domain.service.SubjectLabelDomainService;
import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import com.js.subject.infrastructure.basic.entity.SubjectLabel;
import com.js.subject.infrastructure.basic.entity.SubjectMapping;
import com.js.subject.infrastructure.basic.service.SubjectLabelService;
import com.js.subject.infrastructure.basic.service.SubjectMappingService;
import com.js.subject.infrastructure.basic.service.impl.SubjectCategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaoshuai
 * @date 2024/6/27 10:34
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingServicel;
    @Autowired
    private SubjectCategoryServiceImpl subjectCategoryService;

    public Boolean add(SubjectLabelBo subjectLabelBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.subjectCategoryBo:{}", JSON.toJSONString(subjectLabelBo));
        }
        SubjectLabel subjectLabel = SubjectLabelBoConvert.INSTANCE.convertBoToPo(subjectLabelBo);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean update(SubjectLabelBo subjectLabelBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.subjectCategoryBo:{}", JSON.toJSONString(subjectLabelBo));
        }
        SubjectLabel subjectLabel = SubjectLabelBoConvert.INSTANCE.convertBoToPo(subjectLabelBo);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBo subjectLabelBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.subjectCategoryBo:{}", JSON.toJSONString(subjectLabelBo));
        }
        SubjectLabel subjectLabel = SubjectLabelBoConvert.INSTANCE.convertBoToPo(subjectLabelBo);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public List<SubjectLabelBo> queryLabelByCategoryId(SubjectLabelBo subjectLabelBo) {
        //如果当前分类是一级分类,查询所有标签
        SubjectCategory subjectCategory = subjectCategoryService.queryById(subjectLabelBo.getCategoryId());
        if (CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()) {
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBo.getCategoryId());
            List<SubjectLabel> subjectLabels = subjectLabelService.queryByCondition(subjectLabel);
            List<SubjectLabelBo> subjectLabelBos = SubjectLabelBoConvert.INSTANCE.convertPoToBOList(subjectLabels);
            return subjectLabelBos;
        }
        Long categoryId = subjectLabelBo.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingServicel.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIds = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> subjectLabels = subjectLabelService.batchQueryByLabelIdList(labelIds);
        List<SubjectLabelBo> subjectLabelBos = new ArrayList<>();
        subjectLabels.forEach(label -> {
            SubjectLabelBo bo = new SubjectLabelBo();
            bo.setId(label.getId());
            bo.setCategoryId(categoryId);
            bo.setLabelName(label.getLabelName());
            bo.setSortNum(label.getSortNum());
            subjectLabelBos.add(bo);
        });
        return subjectLabelBos;
    }
}
