package com.js.subject.comm.enums;

import lombok.Getter;


/*
 * @Description: 题目类型枚举
 * 1单选 2多选 3判断 4简答
 *
 * @Author:  jiaoshuai
 * @date:  2024/6/29 11:32
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答"),
    ;

    public int code;

    public String desc;

    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getEnumByCode(int code) {
        for (SubjectInfoTypeEnum subjectInfoTypeEnum : SubjectInfoTypeEnum.values()) {
            if (subjectInfoTypeEnum.code == code) {
                return subjectInfoTypeEnum;
            }
        }
        return null;
    }
}
