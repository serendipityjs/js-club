package com.js.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

    private static final String LOGIN_PREFIX = "loginCode";


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
        //校验用户是否存在,防止用户重复注册
        AuthUser existAuthUser = new AuthUser();
        existAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUser = authUserService.queryByCondition(existAuthUser);
        if (!existUser.isEmpty()) {
            return true;
        }

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        //密码使用md5加盐进行加密，防止明文存储在数据库中
        if (StringUtils.isBlank(authUserBO.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        }

        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
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

    /**
     * 用户更新
     *
     * @param authUserBO
     * @return
     */
    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToPo(authUserBO);
        Integer count = authUserService.update(authUser);
        return count > 0;
    }


    /**
     * 获取用户信息
     *
     * @param authUserBO
     * @return
     */
    @Override
    public AuthUserBO getUserInfo(AuthUserBO authUserBO) {
        AuthUser authUser = new AuthUser();
        authUser.setUserName(authUserBO.getUserName());
        List<AuthUser> userList = authUserService.queryByCondition(authUser);
        if (CollectionUtils.isEmpty(userList)) {
            return new AuthUserBO();
        }
        AuthUser user = userList.get(0);
        return AuthUserBOConverter.INSTANCE.convertEntityToBO(user);
    }


    /**
     * 验证码登录
     *
     * @param validCode
     * @return
     */
    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        return StpUtil.getTokenInfo();
    }

}
