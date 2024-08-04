package com.js.auth.domain.service.impl;

import com.js.auth.common.enums.IsDeletedFlagEnum;
import com.js.auth.domain.convert.AuthUserBOConverter;
import com.js.auth.domain.entity.AuthUserBO;
import com.js.auth.domain.service.AuthUserDomainService;
import com.js.auth.infra.basic.entity.AuthUser;
import com.js.auth.infra.basic.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname AuthUserDomainServiceImpl
 * @Description
 * @Date 2024/8/4
 * @Created by jiaoshuai
 */
@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {
    @Resource
    private AuthUserService authUserService;


    /**
     * 注册
     *
     * @param authUserBO
     * @return
     */
    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser authUser=AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.insert(authUser);
        return count>0;
    }
}
