package com.guiro.tech.mapper;

import com.guiro.tech.dto.jwt.LoginRequestDto;
import com.guiro.tech.dto.jwt.UserSingUpDtoRequest;
import com.guiro.tech.entity.UserEntity;
import com.guiro.tech.enums.Role;

public class UserMapper {

    public static UserSingUpDtoRequest mapToUserEntity(UserEntity user) {
        return new UserSingUpDtoRequest(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getLastName()

        );
    }


    public static UserEntity mapToUserEntity(UserSingUpDtoRequest dto) {
        return new UserEntity(
                dto.id(),
                dto.username(),
                dto.password(),
                dto.name(),
                dto.lastname(),
                Role.USER
        );
    }

    public static LoginRequestDto mapToLoginRequestDto(UserEntity user) {
        return new LoginRequestDto(user.getUsername(), user.getPassword());
    }


}
