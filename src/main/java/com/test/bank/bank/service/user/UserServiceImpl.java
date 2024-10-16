package com.test.bank.bank.service.user;


import com.test.bank.bank.domain.entity.User;
import com.test.bank.bank.exception.ContactDataException;
import com.test.bank.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> sendMoney(String username, String email, double amount) {
        User sender = userRepository.findByUsername(username);
        User recipient = userRepository.findByEmail(email);
        sender.setCurrentBalance(sender.getCurrentBalance() - amount);
        recipient.setCurrentBalance(recipient.getCurrentBalance() + amount);
        userRepository.save(sender);
        userRepository.save(recipient);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> changePhoneNumber(UserDetails userDetails, String phoneNumber) {
        String username = userDetails.getUsername();
        System.out.println(username);
        User user = userRepository.findByUsername(username);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deletePhoneNumber(UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        if(user.getEmail()==null){
            throw new ContactDataException("У пользователя должна быть хотя бы одна контактная информация: email или номер телефона");
        }
        user.setPhoneNumber(null);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> changeEmail(UserDetails userDetails, String email) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        user.setEmail(email);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteEmail(UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        if(user.getPhoneNumber()==null){
            throw new ContactDataException("У пользователя должна быть хотя бы одна контактная информация: email или номер телефона");
        }
        user.setEmail(null);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
