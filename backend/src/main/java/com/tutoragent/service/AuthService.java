package com.tutoragent.service;

import com.tutoragent.dto.AuthDtos;
import com.tutoragent.entity.User;
import com.tutoragent.exception.ApiException;
import com.tutoragent.repository.UserRepository;
import com.tutoragent.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
        this.users = users; this.encoder = encoder; this.jwt = jwt;
    }
    public AuthDtos.AuthResponse register(AuthDtos.RegisterRequest req) {
        users.findByEmail(req.getEmail()).ifPresent(u -> { throw new ApiException("Email exists"); });
        User u = users.save(User.builder().email(req.getEmail()).passwordHash(encoder.encode(req.getPassword())).fullName(req.getFullName()).build());
        return new AuthDtos.AuthResponse(jwt.generate(u.getEmail()), u.getEmail(), u.getFullName());
    }
    public AuthDtos.AuthResponse login(AuthDtos.LoginRequest req) {
        User u = users.findByEmail(req.getEmail()).orElseThrow(() -> new ApiException("Invalid credentials"));
        if (!encoder.matches(req.getPassword(), u.getPasswordHash())) throw new ApiException("Invalid credentials");
        return new AuthDtos.AuthResponse(jwt.generate(u.getEmail()), u.getEmail(), u.getFullName());
    }
    public Long userIdByEmail(String email) { return users.findByEmail(email).orElseThrow(() -> new ApiException("User not found")).getId(); }
}
