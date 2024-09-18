package com.js.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.js.subject.application.convert.SubjectCategoryDtoConvert;
import com.js.subject.application.convert.SubjectLabelDtoConvert;
import com.js.subject.application.dto.SubjectCategoryDto;
import com.js.subject.application.dto.SubjectLabelDto;
import com.js.subject.comm.entity.Result;
import com.js.subject.comm.util.LoginUtil;
import com.js.subject.domain.entity.SubjectCategoryBo;
import com.js.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/24 21:22
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }

            Preconditions.checkNotNull(subjectCategoryDto.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectCategoryDto.getCategoryName()), "分类名称不能为空");
//            Preconditions.checkNotNull(subjectCategoryDto.getCategoryName(), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(), "分类父级id不能为空");

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 查询岗位下大类
     */
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDto>> queryPrimaryCategory(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBos = subjectCategoryDomainService.queryCategory(subjectCategoryBo);

            List<SubjectCategoryDto> subjectCategoryDtos = SubjectCategoryDtoConvert.INSTANCE.convertBoListToDtoList(subjectCategoryBos);
            return Result.ok(subjectCategoryDtos);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }


    /**
     * 查询岗位大类下的分类
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDto>> queryCategoryByPrimary(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(), "分类id不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBos = subjectCategoryDomainService.queryCategory(subjectCategoryBo);
            List<SubjectCategoryDto> subjectCategoryDtos = SubjectCategoryDtoConvert.INSTANCE.convertBoListToDtoList(subjectCategoryBos);
            return Result.ok(subjectCategoryDtos);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 更新分类
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getId(), "分类id不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新分类失败");
        }
    }

    /**
     * 删除分类
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            Preconditions.checkNotNull(subjectCategoryDto.getId(), "分类id不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDtoConvert.INSTANCE.convertDtoToBo(subjectCategoryDto);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除分类失败");
        }
    }

    /**
     * 查询分类及标签一次性
     */
    @PostMapping("/queryCategoryAndLabel")
    public Result<List<SubjectCategoryDto>> queryCategoryAndLabel(@RequestBody SubjectCategoryDto subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryAndLabel.dto:{}"
                        , JSON.toJSONString(subjectCategoryDTO));
            }
            String loginId = LoginUtil.getLoginId();
            System.out.println("loginId:"+loginId);
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "分类id不能为空");
            SubjectCategoryBo subjectCategoryBO = SubjectCategoryDtoConvert.INSTANCE.
                    convertDtoToBo(subjectCategoryDTO);
            List<SubjectCategoryBo> subjectCategoryBOList = subjectCategoryDomainService.queryCategoryAndLabel(subjectCategoryBO);
            List<SubjectCategoryDto> dtoList = new LinkedList<>();
            subjectCategoryBOList.forEach(bo -> {
                SubjectCategoryDto dto = SubjectCategoryDtoConvert.INSTANCE.convertBoToCategoryDTO(bo);
                List<SubjectLabelDto> labelDTOList = SubjectLabelDtoConvert.INSTANCE.subjectLabelBoListToDto(bo.getLabelBOList());
                dto.setLabelDTOList(labelDTOList);
                dtoList.add(dto);
            });
            return Result.ok(dtoList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }



}