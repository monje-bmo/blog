package com.guiro.tech.service.impl;

import com.guiro.tech.dto.jwt.AuthDtoResponse;
import com.guiro.tech.dto.jwt.LoginRequestDto;
import com.guiro.tech.dto.jwt.UserSingUpDtoRequest;
import com.guiro.tech.entity.UserEntity;
import com.guiro.tech.mapper.UserMapper;
import com.guiro.tech.repository.UserRepository;
import com.guiro.tech.service.AuthService;
import com.guiro.tech.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements AuthService {


    private UserRepository repo;
    private JwtService jwtService;

    @Override
    public AuthDtoResponse SingUp(UserSingUpDtoRequest singUpDtoRequest) {

        UserEntity userEntity = UserMapper.mapToUserEntity(singUpDtoRequest);
        repo.save(userEntity);

        return new AuthDtoResponse(jwtService.getToken(userEntity));
    }

    @Override
    public AuthDtoResponse Login(LoginRequestDto loginRequestDto) {
        return null;
    }
}
