package com.test.bank.bank.controller;

import com.test.bank.bank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/sendMoney/{email}/{amount}")
    public ResponseEntity<?> sendMoney(@AuthenticationPrincipal UserDetails userDetails,
                                       @PathVariable("email") String email,
                                       @PathVariable("amount") double amount){
        String username = userDetails.getUsername();
        return userService.sendMoney(username,email,amount);
    }
}
