package com.test.bank.bank.service.search;

import com.test.bank.bank.domain.dto.ClientSearchRequest;
import com.test.bank.bank.domain.dto.SearchUserDTO;
import com.test.bank.bank.domain.entity.User;
import com.test.bank.bank.domain.mapper.ReturnSearchUserMapper;
import com.test.bank.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReturnSearchUserMapper searchUserMapper;

    public Page<SearchUserDTO> searchUser(ClientSearchRequest request){
        Pageable pageable = PageRequest.of(
                request.getPage(),
                request.getSize(),
                Sort.by(Sort.Direction.fromString(request.getSortDirection()), request.getSortBy())
        );

        Specification<User> specification = UserSpecification.filter(request);
        Page<User> usersPage = userRepository.findAll(specification, pageable);
        return usersPage.map(x-> searchUserMapper.userToSearchUserDTO(x));
    }

}
