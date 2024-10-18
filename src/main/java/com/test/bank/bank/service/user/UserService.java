package com.test.bank.bank.service.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    ResponseEntity<?> sendMoney(String username, String email, double amount);

    ResponseEntity<?> changePhoneNumber(UserDetails userDetails, String phoneNumber);

    ResponseEntity<?> deletePhoneNumber(UserDetails userDetails);

    ResponseEntity<?> changeEmail(UserDetails userDetails, String email);

    ResponseEntity<?> deleteEmail(UserDetails userDetails);
    void updateBalance();
}
