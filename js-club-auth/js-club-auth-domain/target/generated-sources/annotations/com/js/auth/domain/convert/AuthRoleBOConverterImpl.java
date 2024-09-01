package com.js.auth.domain.convert;

import com.js.auth.domain.entity.AuthRoleBO;
import com.js.auth.infra.basic.entity.AuthRole;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-24T11:09:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthRoleBOConverterImpl implements AuthRoleBOConverter {

    @Override
    public AuthRole convertBOToEntity(AuthRoleBO authRoleBO) {
        if ( authRoleBO == null ) {
            return null;
        }

        AuthRole authRole = new AuthRole();

        authRole.setId( authRoleBO.getId() );
        authRole.setRoleName( authRoleBO.getRoleName() );
        authRole.setRoleKey( authRoleBO.getRoleKey() );
        authRole.setCreatedBy( authRoleBO.getCreatedBy() );
        authRole.setCreatedTime( authRoleBO.getCreatedTime() );
        authRole.setUpdateBy( authRoleBO.getUpdateBy() );
        authRole.setUpdateTime( authRoleBO.getUpdateTime() );
        authRole.setIsDeleted( authRoleBO.getIsDeleted() );

        return authRole;
    }
}
