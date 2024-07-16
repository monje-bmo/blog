package com.guiro.tech.dto.jwt;

public record UserSingUpDtoRequest(
        Long id,
        String username,
        String password,
        String name,
        String lastname
) {
}
