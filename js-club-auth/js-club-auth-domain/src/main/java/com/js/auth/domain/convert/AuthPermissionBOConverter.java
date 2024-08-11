package com.js.auth.domain.convert;

import com.js.auth.domain.entity.AuthPermissionBO;
import com.js.auth.domain.entity.AuthUserBO;
import com.js.auth.infra.basic.entity.AuthPermission;
import com.js.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:05
 */
@Mapper
public interface AuthPermissionBOConverter {
    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO);
}
