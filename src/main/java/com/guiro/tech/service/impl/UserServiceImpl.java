package com.guiro.tech.service.impl;

import com.guiro.tech.dto.jwt.AuthDtoResponse;
import com.guiro.tech.dto.jwt.LoginRequestDto;
import com.guiro.tech.dto.jwt.UserSingUpDtoRequest;
import com.guiro.tech.entity.UserEntity;
import com.guiro.tech.enums.Role;
import com.guiro.tech.repository.UserRepository;
import com.guiro.tech.service.AuthService;
import com.guiro.tech.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements AuthService {


    private final PasswordEncoder passwordEncoder;
    private UserRepository repo;
    private JwtService jwtService;
    private PasswordEncoder encoder;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthDtoResponse SingUp(UserSingUpDtoRequest request) {

        var userSave = new UserEntity(
                request.id(),
                request.username(),
                encoder.encode(request.password()),
                request.name(),
                request.lastname(),
                Role.USER
        );

        repo.save(userSave);

        return new AuthDtoResponse(jwtService.getToken(userSave));
    }

    @Override
    public AuthDtoResponse Login(LoginRequestDto request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails user = repo.findByUsername(request.username()).orElseThrow();
        String token = jwtService.getToken(user);
        return new AuthDtoResponse(token);
    }
}
