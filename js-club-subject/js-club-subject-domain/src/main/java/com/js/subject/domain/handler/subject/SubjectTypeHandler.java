package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import com.js.subject.domain.entity.SubjectInfoBo;
import com.js.subject.domain.entity.SubjectOptionBo;

/**
 * @author jiaoshuai
 * @date 2024/6/29 11:39
 */
public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际题目的插入
     */
    void add(SubjectInfoBo subjectInfoBo);

    SubjectOptionBo query(Long subjectId);


}
