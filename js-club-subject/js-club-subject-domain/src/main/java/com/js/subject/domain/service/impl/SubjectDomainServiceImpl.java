package com.js.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.js.subject.domain.convert.SubjectBoConvert;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.handler.subject.SubjectTypeHandler;
import com.js.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.js.subject.domain.service.SubjectDomainService;
import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import com.js.subject.infrastructure.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public Boolean add(SubjectInfoBo subjectInfoBo) {
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
        //题目信息表插入
        subjectInfoService.insert(subjectInfo);
        //对应题目表插入
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBo);
        //映射表信息插入

        return null;
    }
}
