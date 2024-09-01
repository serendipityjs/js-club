package com.js.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.domain.convert.SubjectCategoryBoConvert;
import com.js.subject.domain.entity.SubjectCategoryBo;
import com.js.subject.domain.entity.SubjectLabelBo;
import com.js.subject.domain.service.SubjectCategoryDomainService;
import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import com.js.subject.infrastructure.basic.entity.SubjectLabel;
import com.js.subject.infrastructure.basic.entity.SubjectMapping;
import com.js.subject.infrastructure.basic.service.SubjectCategoryService;
import com.js.subject.infrastructure.basic.service.SubjectMappingService;
import com.js.subject.infrastructure.basic.service.impl.SubjectLabelServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author jiaoshuai
 * @date 2024/6/24 16:49
 */

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;
    @Autowired
    private SubjectLabelServiceImpl subjectLabelService;
    @Resource
    private ThreadPoolExecutor labelThreadPool;

    /**
     *
     * @param subjectCategoryBO
     * @return
     */
    @SneakyThrows
    @Override
    public List<SubjectCategoryBo> queryCategoryAndLabel(SubjectCategoryBo subjectCategoryBO) {
        //查询当前大类下所有分类
        return getSubjectCategoryBOS(subjectCategoryBO.getId());
    }


    public void add(SubjectCategoryBo subjectCategoryBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.add.subjectCategoryBo:{}", JSON.toJSONString(subjectCategoryBo));
        }
        SubjectCategory subjectCategory = SubjectCategoryBoConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryBoConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategories = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBo> subjectCategoryBos = SubjectCategoryBoConvert.INSTANCE.convertToBoList(subjectCategories);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.queryCategory.subjectCategoryBos:{}", JSON.toJSON(subjectCategoryBos));
        }
        subjectCategoryBos.forEach(bo -> {
            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });

        return subjectCategoryBos;
    }

    @Override
    public Boolean update(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryBoConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryBoConvert.INSTANCE.convertToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }


    /***
     * 根据一级分类id获取各个分类下的所有标签
     *
     * @param categoryId
     * @return
     */
    private List<SubjectCategoryBo> getSubjectCategoryBOS(Long categoryId) {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(categoryId);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryCategoryAndLabel.subjectCategoryList:{}",
                    JSON.toJSONString(subjectCategoryList));
        }
        List<SubjectCategoryBo> categoryBOList = SubjectCategoryBoConvert.INSTANCE.convertToBoList(subjectCategoryList);
        Map<Long, List<SubjectLabelBo>> map = new HashMap<>();
        List<CompletableFuture<Map<Long, List<SubjectLabelBo>>>> completableFutureList = categoryBOList.stream().map(category ->
                CompletableFuture.supplyAsync(() -> getLabelBOList(category), labelThreadPool)
        ).collect(Collectors.toList());
        completableFutureList.forEach(future -> {
            try {
                Map<Long, List<SubjectLabelBo>> resultMap = future.get();
                if (!CollectionUtils.isEmpty(resultMap)) {
                    map.putAll(resultMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        categoryBOList.forEach(categoryBO -> {
            if (!CollectionUtils.isEmpty(map.get(categoryBO.getId()))) {
                categoryBO.setLabelBOList(map.get(categoryBO.getId()));
            }
        });
        return categoryBOList;
    }


    /**
     * 获取各个分类下的标签(使用CompletableFuture异步执行)
     *
     * @param category
     * @return
     */
    private Map<Long, List<SubjectLabelBo>> getLabelBOList(SubjectCategoryBo category) {
        if (log.isInfoEnabled()) {
            log.info("getLabelBOList:{}", JSON.toJSONString(category));
        }
        Map<Long, List<SubjectLabelBo>> labelMap = new HashMap<>();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(category.getId());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return null;
        }
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryByLabelIdList(labelIdList);
        List<SubjectLabelBo> labelBOList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBo subjectLabelBO = new SubjectLabelBo();
            subjectLabelBO.setId(label.getId());
            subjectLabelBO.setLabelName(label.getLabelName());
            subjectLabelBO.setCategoryId(label.getCategoryId());
            subjectLabelBO.setSortNum(label.getSortNum());
            labelBOList.add(subjectLabelBO);
        });
        labelMap.put(category.getId(), labelBOList);
        return labelMap;
    }


}
