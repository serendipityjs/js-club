package com.js.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.google.gson.Gson;
import com.js.auth.common.enums.AuthUserStatusEnum;
import com.js.auth.common.enums.IsDeletedFlagEnum;
import com.js.auth.domain.constants.AuthConstant;
import com.js.auth.domain.convert.AuthUserBOConverter;
import com.js.auth.domain.entity.AuthUserBO;
import com.js.auth.domain.redis.RedisUtil;
import com.js.auth.domain.service.AuthUserDomainService;
import com.js.auth.infra.basic.entity.*;
import com.js.auth.infra.basic.service.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    private static final String salt = "jiaoshuai";

    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";


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
        Long roleId = roleResult.getId();
        Long userId = authUser.getId();
        authUserRole.setRoleId(roleId);
        authUserRole.setUserId(userId);
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);

        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(roleId);
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.
                queryByCondition(authRolePermission);

        List<Long> permissionIdList = rolePermissionList.stream()
                .map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        //根据roleId查权限
        List<AuthPermission> permissionList = authPermissionService.queryByRoleList(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(permissionList));
        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        Integer count = authUserService.update(authUser);
        return count > 0;
    }
}
