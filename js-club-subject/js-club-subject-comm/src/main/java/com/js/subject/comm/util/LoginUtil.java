package com.js.subject.comm.util;

import com.js.subject.comm.context.LoginContextHolder;

/**
 * @Classname LoginUtil
 * @Description
 * @Date 2024/9/16
 * @Created by jiaoshuai
 */
public class LoginUtil {
    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }
}
