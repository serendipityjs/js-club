package com.js.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.js.subject.comm.entity.PageResult;
import com.js.subject.comm.enums.IsDeletedFlagEnum;
import com.js.subject.domain.convert.SubjectBoConvert;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;
import com.js.subject.domain.handler.subject.SubjectTypeHandler;
import com.js.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.js.subject.domain.service.SubjectDomainService;
import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import com.js.subject.infrastructure.basic.entity.SubjectLabel;
import com.js.subject.infrastructure.basic.entity.SubjectMapping;
import com.js.subject.infrastructure.basic.service.SubjectInfoService;
import com.js.subject.infrastructure.basic.service.SubjectLabelService;
import com.js.subject.infrastructure.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:22
 */

@Service
@Slf4j
public class SubjectDomainServiceImpl implements SubjectDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;
    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    public void add(SubjectInfoBo subjectInfoBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectDomainServiceImpl.add.subjectCategoryBo:{}", JSON.toJSONString(subjectInfoBo));
        }

        /**
         * 假设我们都写在主流程里面 判断type，单选的调用单选的service，多选的调用多选的servcie
         * 势必会导致一大堆的if判断
         * 可以使用工厂模式加策略模式的形式
         * 一个工厂包含四种类型，根据传入的type自动映射选择处理
         * */
        SubjectInfo subjectInfo = SubjectBoConvert.INSTANCE.convertBoToPo(subjectInfoBo);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        //题目信息表插入
        subjectInfoService.insert(subjectInfo);
        //对应题目表插入
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBo.setId(subjectInfo.getId());
        handler.add(subjectInfoBo);
        //映射表信息插入
        List<Integer> categoryIds = subjectInfoBo.getCategoryIds();
        List<Integer> labelIds = subjectInfoBo.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.stream().forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInset(subjectMappingList);
    }

    /**
     * 查询题目详情
     *
     * @param subjectInfoBo
     * @return
     */
    @Override
    public SubjectInfoBo getSubjectInfo(SubjectInfoBo subjectInfoBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectDomainServiceImpl.getSubjectInfo.subjectCategoryBo:{}", JSON.toJSONString(subjectInfoBo));
        }
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBo.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBo optionBO = handler.query(subjectInfo.getId());
        SubjectInfoBo bo = SubjectBoConvert.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryByLabelIdList(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);
        return bo;
    }


    /**
     * 题目分页查询
     *
     * @param subjectInfoBo
     * @return
     */
    @Override
    public PageResult<SubjectInfoBo> queryPage(SubjectInfoBo subjectInfoBo) {
        if (log.isInfoEnabled()) {
            log.info("SubjectDomainServiceImpl.queryPage.subjectCategoryBo:{}", JSON.toJSONString(subjectInfoBo));
        }
        PageResult<SubjectInfoBo> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBo.getPageNo());
        pageResult.setPageSize(subjectInfoBo.getPageSize());
        int start = (subjectInfoBo.getPageNo() - 1) * subjectInfoBo.getPageSize() + 1;
        SubjectInfo subjectInfo = SubjectBoConvert.INSTANCE.convertBoToPo(subjectInfoBo);
        int count = subjectInfoService.getCount(subjectInfo, subjectInfoBo.getCategoryId(), subjectInfoBo.getLabelId());
        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBo.getCategoryId(),
                subjectInfoBo.getLabelId(), start, subjectInfoBo.getPageSize());
        List<SubjectInfoBo> subjectInfoBoList = SubjectBoConvert.INSTANCE.SubjectPoListToBo(subjectInfoList);
        pageResult.setRecords(subjectInfoBoList);
        pageResult.setTotal(count);
        return pageResult;
    }
}
