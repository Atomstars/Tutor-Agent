package com.tutoragent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class AuthDtos {
    @Data
    public static class RegisterRequest {
        @Email @NotBlank private String email;
        @NotBlank private String password;
        @NotBlank private String fullName;
    }
    @Data
    public static class LoginRequest {
        @Email @NotBlank private String email;
        @NotBlank private String password;
    }
    @Data
    public static class AuthResponse {
        private final String token;
        private final String email;
        private final String fullName;
    }
}
