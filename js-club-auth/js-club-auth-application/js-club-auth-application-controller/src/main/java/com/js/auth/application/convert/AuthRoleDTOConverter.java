package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthRoleDto;
import com.js.auth.domain.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:05
 */
@Mapper
public interface AuthRoleDTOConverter {
    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);
    AuthRoleBO convertDTOToBO(AuthRoleDto authRoleDTO);


}
