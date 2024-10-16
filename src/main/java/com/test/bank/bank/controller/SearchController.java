package com.test.bank.bank.controller;

import com.test.bank.bank.domain.dto.ClientSearchRequest;
import com.test.bank.bank.domain.dto.SearchUserDTO;
import com.test.bank.bank.domain.entity.User;
import com.test.bank.bank.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private  SearchService searchService;

    @GetMapping("/user")
    public Page<SearchUserDTO> searchClients(ClientSearchRequest request) {
        return searchService.searchUser(request);
    }


}
