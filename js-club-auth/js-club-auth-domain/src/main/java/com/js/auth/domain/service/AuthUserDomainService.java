package com.js.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.js.auth.domain.entity.AuthUserBO;

/**
 * @Classname AuthUserDomainService
 * @Description
 * @Date 2024/8/4
 * @Created by jiaoshuai
 */
public interface AuthUserDomainService {

    /**
     * 注册
     *
     * @param authUserBO
     * @return
     */
    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    /**
     * 获取用户信息
     *
     * @param authUserBO
     * @return
     */
    AuthUserBO getUserInfo(AuthUserBO authUserBO);
}
