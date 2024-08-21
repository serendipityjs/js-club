package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthRolePermissionDto;
import com.js.auth.domain.entity.AuthRolePermissionBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T21:06:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthRolePermissionDTOConverterImpl implements AuthRolePermissionDTOConverter {

    @Override
    public AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDto authRolePermissionDto) {
        if ( authRolePermissionDto == null ) {
            return null;
        }

        AuthRolePermissionBO authRolePermissionBO = new AuthRolePermissionBO();

        return authRolePermissionBO;
    }
}
