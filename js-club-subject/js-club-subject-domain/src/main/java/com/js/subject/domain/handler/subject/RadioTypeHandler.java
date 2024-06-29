package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.entity.SubjectInfoBo;
import org.springframework.stereotype.Component;

/**
 * 单选题目的策略类
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:45
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        //单选题目的插入
    }
}
