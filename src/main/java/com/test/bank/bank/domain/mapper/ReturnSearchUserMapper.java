package com.test.bank.bank.domain.mapper;

import com.test.bank.bank.domain.dto.SearchUserDTO;
import com.test.bank.bank.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ReturnSearchUserMapper {

    public SearchUserDTO userToSearchUserDTO(User user){
        SearchUserDTO userDTO = SearchUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .username(user.getUsername())
                .currentBalance(user.getCurrentBalance())
                .build();
        return userDTO;
    }
}
