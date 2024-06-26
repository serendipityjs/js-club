package com.js.subject.comm.enums;

import lombok.Getter;

/**
 * @author jiaoshuai
 * @date 2024/6/24 21:35
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "请求成功"),
    FAIL(500, "请求失败");

    private int code;

    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeValue) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.code == codeValue) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
