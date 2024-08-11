package com.js.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.js.auth.common.enums.AuthUserStatusEnum;
import com.js.auth.common.enums.IsDeletedFlagEnum;
import com.js.auth.domain.constants.AuthConstant;
import com.js.auth.domain.convert.AuthUserBOConverter;
import com.js.auth.domain.entity.AuthUserBO;
import com.js.auth.domain.service.AuthUserDomainService;
import com.js.auth.infra.basic.entity.AuthRole;
import com.js.auth.infra.basic.entity.AuthUser;
import com.js.auth.infra.basic.entity.AuthUserRole;
import com.js.auth.infra.basic.service.AuthRoleService;
import com.js.auth.infra.basic.service.AuthUserRoleService;
import com.js.auth.infra.basic.service.AuthUserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    private static final String salt = "jiaoshuai";


    /**
     * 注册
     *
     * @param authUserBO
     * @return
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        //密码使用md5加盐进行加密，防止明文存储在数据库中
        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        Integer count = authUserService.insert(authUser);
        //建立一个初步的角色的关联
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setRoleId(roleResult.getId());
        authUserRole.setUserId(authUser.getId());
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);
        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        Integer count = authUserService.update(authUser);
        return count > 0;
    }
}
