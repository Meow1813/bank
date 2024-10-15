package com.test.bank.bank.service.user;

import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> sendMoney(String username, String email, double amount);
}
