package com.test.bank.bank.service.search;

import com.test.bank.bank.domain.dto.ClientSearchRequest;
import com.test.bank.bank.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface SearchService {
    Page<User> searchUser(ClientSearchRequest request);
}
