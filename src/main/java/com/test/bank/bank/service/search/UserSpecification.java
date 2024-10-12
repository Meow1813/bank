package com.test.bank.bank.service.search;

import com.test.bank.bank.domain.dto.ClientSearchRequest;
import com.test.bank.bank.domain.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<User> filter(ClientSearchRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (request.getUsername() != null) {
                predicates.add(criteriaBuilder.like(root.get("username"), request.getUsername() + "%"));
            }
            if (request.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), request.getName() + "%"));
            }
            if (request.getSurname() != null) {
                predicates.add(criteriaBuilder.like(root.get("surname"), request.getSurname() + "%"));
            }
            if (request.getPatronymic() != null) {
                predicates.add(criteriaBuilder.like(root.get("patronymic"), request.getPatronymic() + "%"));
            }
            if (request.getEmail() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), request.getEmail()));
            }

            // Фильтр по номеру телефона (точное совпадение)
            if (request.getPhoneNumber() != null) {
                predicates.add(criteriaBuilder.equal(root.get("phoneNumber"), request.getPhoneNumber()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
