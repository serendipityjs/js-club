package com.js.auth.domain.service.impl;

import com.js.auth.common.enums.IsDeletedFlagEnum;
import com.js.auth.domain.entity.AuthRolePermissionBO;
import com.js.auth.domain.service.AuthRolePermissionDomainService;
import com.js.auth.infra.basic.entity.AuthRolePermission;
import com.js.auth.infra.basic.service.AuthRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        List<AuthRolePermission> rolePermissionList = new LinkedList<>();
        Long roleId = authRolePermissionBO.getRoleId();
        int count = 0;
        List<Long> permissionIdList = authRolePermissionBO.getPermissionIdList();
        if (!CollectionUtils.isEmpty(permissionIdList)) {
            permissionIdList.forEach(permissionId -> {
                AuthRolePermission authRolePermission = new AuthRolePermission();
                authRolePermission.setRoleId(roleId);
                authRolePermission.setPermissionId(permissionId);
                authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                rolePermissionList.add(authRolePermission);
            });
            count = authRolePermissionService.batchInsert(rolePermissionList);
        }
        return count > 0;
    }


}
