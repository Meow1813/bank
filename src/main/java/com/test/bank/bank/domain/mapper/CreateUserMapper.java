package com.test.bank.bank.domain.mapper;

import com.test.bank.bank.domain.dto.UserCreateDTO;
import com.test.bank.bank.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User userCreateDtoToUserEntity(UserCreateDTO userDTO){
        User user = User.builder()
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .patronymic(userDTO.getPatronymic())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .currentBalance(userDTO.getStartBalance())
                .startBalance(userDTO.getStartBalance())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();

        return user;
    }
}
