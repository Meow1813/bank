package com.test.bank.bank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {
    private String username;
    private String name;
    private String surname;
    private String patronymic;
    private String password;
    private String phoneNumber;
    private String email;
    private double startBalance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDTO that = (UserCreateDTO) o;
        return Double.compare(startBalance, that.startBalance) == 0 && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(password, that.password) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, surname, patronymic, password, phoneNumber, email, startBalance);
    }
}
