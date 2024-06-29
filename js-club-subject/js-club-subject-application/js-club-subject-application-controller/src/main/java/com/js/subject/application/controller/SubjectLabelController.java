package com.js.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.js.subject.application.convert.SubjectLabelDtoConvert;
import com.js.subject.application.dto.SubjectLabelDto;
import com.js.subject.comm.entity.Result;
import com.js.subject.domain.entity.SubjectLabelBo;
import com.js.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签controller
 *
 * @author jiaoshuai
 * @date 2024/6/27 10:16
 */
@RestController
@Slf4j
@RequestMapping("/subject/label")
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDto));
            }

            Preconditions.checkArgument(StringUtils.isNotBlank(subjectLabelDto.getLabelName()), "标签名称不能为空");

            SubjectLabelBo subjectLabelBo = SubjectLabelDtoConvert.INSTANCE.subjectLabelDtoToBO(subjectLabelDto);
            Boolean result = subjectLabelDomainService.add(subjectLabelBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDto));
            }

            Preconditions.checkNotNull(subjectLabelDto.getId(), "标签id不能为空");

            SubjectLabelBo subjectLabelBo = SubjectLabelDtoConvert.INSTANCE.subjectLabelDtoToBO(subjectLabelDto);
            Boolean result = subjectLabelDomainService.update(subjectLabelBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDto));
            }

            Preconditions.checkNotNull(subjectLabelDto.getId(), "标签id不能为空");

            SubjectLabelBo subjectLabelBo = SubjectLabelDtoConvert.INSTANCE.subjectLabelDtoToBO(subjectLabelDto);
            Boolean result = subjectLabelDomainService.delete(subjectLabelBo);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.delete.error:{}", e.getMessage(), e);
            return Result.fail("更新标签失败");
        }
    }


    /**
     * 查询分类下标签
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDto>> queryLabelByCategoryId(@RequestBody SubjectLabelDto subjectLabelDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDto));
            }

            Preconditions.checkNotNull(subjectLabelDto.getCategoryId(), "分类id不能为空");

            SubjectLabelBo subjectLabelBo = SubjectLabelDtoConvert.INSTANCE.subjectLabelDtoToBO(subjectLabelDto);
            List<SubjectLabelBo> subjectLabelBos = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBo);
            List<SubjectLabelDto> subjectLabelDtos = SubjectLabelDtoConvert.INSTANCE.subjectLabelBoListToDto(subjectLabelBos);
            return Result.ok(subjectLabelDtos);
        } catch (Exception e) {
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("查询分类下标签失败");
        }
    }
}
