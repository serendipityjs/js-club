package com.js.auth.application.convert;

import com.js.auth.application.dto.AuthUserDto;
import com.js.auth.domain.entity.AuthUserBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-31T10:45:42+0800",
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

    @Override
    public AuthUserDto convertBOToDTO(AuthUserBO authUserBO) {
        if ( authUserBO == null ) {
            return null;
        }

        AuthUserDto authUserDto = new AuthUserDto();

        authUserDto.setId( authUserBO.getId() );
        authUserDto.setUserName( authUserBO.getUserName() );
        authUserDto.setNickName( authUserBO.getNickName() );
        authUserDto.setEmail( authUserBO.getEmail() );
        authUserDto.setPhone( authUserBO.getPhone() );
        authUserDto.setPassword( authUserBO.getPassword() );
        authUserDto.setSex( authUserBO.getSex() );
        authUserDto.setAvatar( authUserBO.getAvatar() );
        authUserDto.setStatus( authUserBO.getStatus() );
        authUserDto.setIntroduce( authUserBO.getIntroduce() );
        authUserDto.setExtJson( authUserBO.getExtJson() );
        authUserDto.setCreatedBy( authUserBO.getCreatedBy() );
        authUserDto.setCreatedTime( authUserBO.getCreatedTime() );
        authUserDto.setUpdateBy( authUserBO.getUpdateBy() );
        authUserDto.setUpdateTime( authUserBO.getUpdateTime() );
        authUserDto.setIsDeleted( authUserBO.getIsDeleted() );

        return authUserDto;
    }
}
