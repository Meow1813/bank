package com.test.bank.bank.repository;

import com.test.bank.bank.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String login);
    User findByEmail(String email);
}
