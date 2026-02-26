package com.landregistry.land_registry.controller;

import com.landregistry.land_registry.dto.*;
import com.landregistry.land_registry.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        authService.signup(request);
        return "Owner registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/me")
    public UserResponse getLoggedInUser(Authentication authentication) {

        String email = authentication.getName(); // set in JwtAuthFilter

        return authService.getCurrentUser(email);
    }

}

