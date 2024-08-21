package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthUserDto;
import com.js.auth.domain.entity.AuthUserBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T21:12:13+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class AuthUserDTOConverterImpl implements AuthUserDTOConverter {

    @Override
    public AuthUserBO convertDTOToBO(AuthUserDto authUserDto) {
        if ( authUserDto == null ) {
            return null;
        }

        AuthUserBO authUserBO = new AuthUserBO();

        authUserBO.setId( authUserDto.getId() );
        authUserBO.setUserName( authUserDto.getUserName() );
        authUserBO.setNickName( authUserDto.getNickName() );
        authUserBO.setEmail( authUserDto.getEmail() );
        authUserBO.setPhone( authUserDto.getPhone() );
        authUserBO.setPassword( authUserDto.getPassword() );
        authUserBO.setSex( authUserDto.getSex() );
        authUserBO.setAvatar( authUserDto.getAvatar() );
        authUserBO.setStatus( authUserDto.getStatus() );
        authUserBO.setIntroduce( authUserDto.getIntroduce() );
        authUserBO.setExtJson( authUserDto.getExtJson() );
        authUserBO.setCreatedBy( authUserDto.getCreatedBy() );
        authUserBO.setCreatedTime( authUserDto.getCreatedTime() );
        authUserBO.setUpdateBy( authUserDto.getUpdateBy() );
        authUserBO.setUpdateTime( authUserDto.getUpdateTime() );
        authUserBO.setIsDeleted( authUserDto.getIsDeleted() );

        return authUserBO;
    }
}
