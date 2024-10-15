package com.test.bank.bank.controller;

import com.test.bank.bank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
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

    @PutMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<?> changePhoneNumber(@AuthenticationPrincipal UserDetails userDetails,
                                               @PathVariable("phoneNumber")String phoneNumber){
        return userService.changePhoneNumber(userDetails, phoneNumber);
    }

    @DeleteMapping("/phoneNumber")
    public ResponseEntity<?> deletePhoneNumber(@AuthenticationPrincipal UserDetails userDetails){
        return userService.deletePhoneNumber(userDetails);
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<?> changeEmail(@AuthenticationPrincipal UserDetails userDetails,
                                               @PathVariable("email")String email){
        return userService.changeEmail(userDetails, email);
    }

    @DeleteMapping("/email")
    public ResponseEntity<?> deleteEmail(@AuthenticationPrincipal UserDetails userDetails){
        return userService.deleteEmail(userDetails);
    }
}
