package com.js.auth.domain.convert;

import com.js.auth.domain.entity.AuthPermissionBO;
import com.js.auth.infra.basic.entity.AuthPermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T21:06:17+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthPermissionBOConverterImpl implements AuthPermissionBOConverter {

    @Override
    public AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO) {
        if ( authPermissionBO == null ) {
            return null;
        }

        AuthPermission authPermission = new AuthPermission();

        authPermission.setId( authPermissionBO.getId() );
        authPermission.setName( authPermissionBO.getName() );
        authPermission.setParentId( authPermissionBO.getParentId() );
        authPermission.setType( authPermissionBO.getType() );
        authPermission.setMenuUrl( authPermissionBO.getMenuUrl() );
        authPermission.setStatus( authPermissionBO.getStatus() );
        authPermission.setShow( authPermissionBO.getShow() );
        authPermission.setIcon( authPermissionBO.getIcon() );
        authPermission.setPermissionKey( authPermissionBO.getPermissionKey() );
        authPermission.setCreatedBy( authPermissionBO.getCreatedBy() );
        authPermission.setCreatedTime( authPermissionBO.getCreatedTime() );
        authPermission.setUpdateBy( authPermissionBO.getUpdateBy() );
        authPermission.setUpdateTime( authPermissionBO.getUpdateTime() );
        authPermission.setIsDeleted( authPermissionBO.getIsDeleted() );

        return authPermission;
    }
}
