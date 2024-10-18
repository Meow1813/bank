package com.test.bank.bank.controller;

import com.test.bank.bank.domain.dto.UserCreateDTO;
import com.test.bank.bank.service.stuff.StuffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
@Slf4j
public class StuffController {
    @Autowired
    private StuffService stuffService;

    @PostMapping("/addUser")
    public ResponseEntity<?> user(@RequestBody UserCreateDTO user){
        return stuffService.addUser(user);

    }


}
