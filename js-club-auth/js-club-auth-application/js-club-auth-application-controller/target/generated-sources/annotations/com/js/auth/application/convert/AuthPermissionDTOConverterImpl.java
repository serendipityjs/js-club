package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthPermissionDto;
import com.js.auth.domain.entity.AuthPermissionBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-24T11:09:39+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthPermissionDTOConverterImpl implements AuthPermissionDTOConverter {

    @Override
    public AuthPermissionBO convertDTOToBO(AuthPermissionDto authPermissionDto) {
        if ( authPermissionDto == null ) {
            return null;
        }

        AuthPermissionBO authPermissionBO = new AuthPermissionBO();

        return authPermissionBO;
    }
}
