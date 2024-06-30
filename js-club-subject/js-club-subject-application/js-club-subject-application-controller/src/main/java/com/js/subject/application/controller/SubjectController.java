package com.js.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.js.subject.application.convert.SubjectAnswerDtoConverter;
import com.js.subject.application.convert.SubjectInfoDtoConverter;
import com.js.subject.application.dto.SubjectInfoDto;
import com.js.subject.comm.entity.Result;
import com.js.subject.domain.entity.SubjectAnswerBo;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.service.SubjectDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiaoshuai
 * @date 2024/6/23 22:50
 */
@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectDomainService subjectDomainService;

    /**
     * 新增题目
     */
    @PostMapping("/add")
    public Result add(@RequestBody SubjectInfoDto subjectInfoDto) {
        try {
            if (log.isInfoEnabled()) {//这里加这个判断是因为在高并发情况下,如果不加,会导致不管日志打不打印,都会将后面json进行转化,很耗性能
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDto));
            }

            Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDto.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDto.getCategoryIds()), "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDto.getLabelIds()), "标签id不能为空");


            SubjectInfoBo subjectInfoBo = SubjectInfoDtoConverter.INSTANCE.subjectInfoDtoToBo(subjectInfoDto);
            List<SubjectAnswerBo> subjectAnswerBo = SubjectAnswerDtoConverter.INSTANCE.subjectAnswerDtoListToBoList(subjectInfoDto.getOptionList());
            subjectInfoBo.setOptionList(subjectAnswerBo);
            subjectDomainService.add(subjectInfoBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }


}
