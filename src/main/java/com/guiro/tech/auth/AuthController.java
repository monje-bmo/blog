package com.guiro.tech.auth;

import com.guiro.tech.dto.jwt.AuthDtoResponse;
import com.guiro.tech.dto.jwt.LoginRequestDto;
import com.guiro.tech.dto.jwt.UserSingUpDtoRequest;
import com.guiro.tech.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthDtoResponse> login(@RequestBody LoginRequestDto request) {

        return ResponseEntity.ok(authService.Login(request));
    }

    @PostMapping("/singup")
    public ResponseEntity<AuthDtoResponse> singup(@RequestBody UserSingUpDtoRequest request) {
        return ResponseEntity.ok(authService.SingUp(request));
    }
}
