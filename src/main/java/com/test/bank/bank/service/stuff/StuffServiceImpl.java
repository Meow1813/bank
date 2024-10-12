package com.test.bank.bank.service.stuff;


import com.test.bank.bank.domain.dto.UserCreateDTO;
import com.test.bank.bank.domain.mapper.CreateUserMapper;
import com.test.bank.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StuffServiceImpl implements StuffService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CreateUserMapper createUserMapper;


    @Override
    public ResponseEntity<?> addUser(UserCreateDTO user) {
        userRepository.save(createUserMapper.userCreateDtoToUserEntity(user));
        return ResponseEntity.ok().build();
    }
}
