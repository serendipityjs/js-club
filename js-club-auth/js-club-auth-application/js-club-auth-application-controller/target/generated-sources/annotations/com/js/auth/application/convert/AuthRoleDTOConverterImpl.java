package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthRoleDto;
import com.js.auth.domain.entity.AuthRoleBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-24T11:09:39+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthRoleDTOConverterImpl implements AuthRoleDTOConverter {

    @Override
    public AuthRoleBO convertDTOToBO(AuthRoleDto authRoleDTO) {
        if ( authRoleDTO == null ) {
            return null;
        }

        AuthRoleBO authRoleBO = new AuthRoleBO();

        return authRoleBO;
    }
}
