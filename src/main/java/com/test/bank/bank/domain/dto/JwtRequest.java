package com.test.bank.bank.domain.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
