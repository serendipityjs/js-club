package com.js.subject.domain.entity;

import lombok.Data;

/**
 * 题目答案bo
 *
 * @author jiaoshuai
 * @date 2024/6/28 10:47
 */
@Data
public class SubjectAnswerBo {

    /**
     * 答案选项标识
     */
    private String optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private String isCorrect;

}
