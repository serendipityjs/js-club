package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthUserDto;
import com.js.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author jiaoshuai
 * @date 2024/6/29 10:05
 */
@Mapper
public interface AuthUserDTOConverter {
    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBO convertDTOToBO(AuthUserDto authUserDto);

    AuthUserDto convertBOToDTO(AuthUserBO authUserBO);
}
