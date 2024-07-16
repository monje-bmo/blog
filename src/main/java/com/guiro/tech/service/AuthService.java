package com.guiro.tech.service;

import com.guiro.tech.dto.jwt.AuthDtoResponse;
import com.guiro.tech.dto.jwt.LoginRequestDto;
import com.guiro.tech.dto.jwt.UserSingUpDtoRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthDtoResponse SingUp(UserSingUpDtoRequest singUpDtoRequest);

    AuthDtoResponse Login(LoginRequestDto loginRequestDto);

}
