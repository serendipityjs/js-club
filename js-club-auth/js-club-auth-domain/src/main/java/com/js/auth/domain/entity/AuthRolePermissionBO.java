package com.js.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (AuthPermission)实体类
 *
 * @author makejava
 * @since 2024-08-03 19:51:29
 */
@Data
public class AuthRolePermissionBO implements Serializable {
    private static final long serialVersionUID = -58669294418617796L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;


}

