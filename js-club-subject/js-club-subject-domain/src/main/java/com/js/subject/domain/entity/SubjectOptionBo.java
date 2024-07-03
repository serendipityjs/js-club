package com.js.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/*
 * @Description: 题目答案以及题目选项
 *
 * @Author: jiaoshuai
 * @date:  2024/7/1 11:26
 */
@Data
public class SubjectOptionBo implements Serializable {
    private static final long serialVersionUID = -21142611928142432L;

    /**
     * 题目答案
     */
    private String subjectAnswer;


    /**
     * 答案选项
     */
    private List<SubjectAnswerBo> optionList;


}

