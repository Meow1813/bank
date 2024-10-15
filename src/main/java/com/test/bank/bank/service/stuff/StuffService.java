package com.test.bank.bank.service.stuff;


import com.test.bank.bank.domain.dto.UserCreateDTO;
import org.springframework.http.ResponseEntity;

public interface StuffService {
   ResponseEntity<?> addUser(UserCreateDTO user);
}
