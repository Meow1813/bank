package com.test.bank.bank.service.auth;

import com.test.bank.bank.domain.dto.JwtRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> creteAuthToken(JwtRequest authRequest);
}
