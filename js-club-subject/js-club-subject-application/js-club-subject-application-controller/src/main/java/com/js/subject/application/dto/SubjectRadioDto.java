package com.js.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/*
 * @Description: 单选题dto类
 *
 * @Author:  jiaoshuai
 * @date:  2024/6/29 21:25
 */
@Data
public class SubjectRadioDto implements Serializable {
    private static final long serialVersionUID = -20914200280811714L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * a,b,c,d
     */
    private Integer optionType;

    /**
     * 选项内容
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;

}

