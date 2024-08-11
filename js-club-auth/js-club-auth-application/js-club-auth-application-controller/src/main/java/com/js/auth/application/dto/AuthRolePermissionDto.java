package com.js.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2024-08-03 19:51:32
 */
@Data
public class AuthRolePermissionDto implements Serializable {
    private static final long serialVersionUID = -82629743217750026L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;

}

