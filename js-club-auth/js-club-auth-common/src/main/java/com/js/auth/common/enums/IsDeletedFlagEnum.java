package com.js.auth.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 *
 * @author jiaoshuai
 * @date 2024/6/26 11:36
 */
@Getter
public enum IsDeletedFlagEnum {
    UN_DELETED(0, "未删除"),

    DELETED(1, "已删除");


    private int code;

    private String desc;

    IsDeletedFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeValue) {
        for (IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()) {
            if (resultCodeEnum.code == codeValue) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
