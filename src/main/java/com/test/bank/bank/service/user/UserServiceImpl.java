package com.test.bank.bank.service.user;


import com.test.bank.bank.domain.entity.User;
import com.test.bank.bank.exception.ContactDataException;
import com.test.bank.bank.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public ResponseEntity<?> sendMoney(String username, String email, double amount) {

        if(amount<0){
            return new ResponseEntity<>("сумма не может быть отрицательной", HttpStatus.BAD_REQUEST);
        }

        User sender = userRepository.findByUsername(username);
        User recipient = userRepository.findByEmail(email);

        if(sender.getCurrentBalance()< amount){
            return new ResponseEntity<>("сумма отправлений не может привышать ваш баланс", HttpStatus.BAD_REQUEST);
        }


        sender.setCurrentBalance(sender.getCurrentBalance() - amount);
        recipient.setCurrentBalance(recipient.getCurrentBalance() + amount);

        synchronized (this) {
            userRepository.save(sender);
            userRepository.save(recipient);
        }

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
    @Override
    @Scheduled(fixedRate = 60000)
    public void updateBalance(){
        List<User> users = userRepository.findAll();
        for(User user: users){
            double newBalance = user.getCurrentBalance()*1.05;
            double maxBalance = user.getStartBalance()*3.07;
            if(newBalance>maxBalance){
                newBalance=maxBalance;
            }

            user.setCurrentBalance(newBalance);
            userRepository.save(user);
        }
        log.info("баланс пользователей обновлен");
    }
}
