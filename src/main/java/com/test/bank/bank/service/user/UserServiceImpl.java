package com.test.bank.bank.service.user;


import com.test.bank.bank.domain.entity.User;
import com.test.bank.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> sendMoney(String username, String email, double amount) {
        User sender = userRepository.findByUsername(username);
        User recipient = userRepository.findByEmail(email);
        sender.setBalance(sender.getBalance() - amount);
        recipient.setBalance(recipient.getBalance() + amount);
        userRepository.save(sender);
        userRepository.save(recipient);
        return ResponseEntity.ok().build();
    }
}
