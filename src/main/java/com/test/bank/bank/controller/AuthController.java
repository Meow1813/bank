package com.test.bank.bank.controller;

import com.test.bank.bank.domain.dto.JwtRequest;
import com.test.bank.bank.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
@Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> creteAuthToken(@RequestBody JwtRequest authRequest) {

        return authService.creteAuthToken(authRequest);
    }
}
