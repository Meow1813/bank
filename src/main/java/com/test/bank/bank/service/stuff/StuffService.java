package com.test.bank.bank.service.stuff;


import com.test.bank.bank.domain.entity.User;
import org.springframework.http.ResponseEntity;

public interface StuffService {
   ResponseEntity<?> addUser(User user);
}
