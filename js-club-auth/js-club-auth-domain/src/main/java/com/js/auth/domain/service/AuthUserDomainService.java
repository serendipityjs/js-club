package com.js.auth.domain.service;

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
}
