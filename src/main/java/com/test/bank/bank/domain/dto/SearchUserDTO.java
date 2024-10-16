package com.test.bank.bank.domain.dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchUserDTO {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private String email;
    private double currentBalance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchUserDTO that = (SearchUserDTO) o;
        return Double.compare(currentBalance, that.currentBalance) == 0 && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, surname, patronymic, phoneNumber, email, currentBalance);
    }
}
