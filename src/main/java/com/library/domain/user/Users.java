package com.library.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Users {
    @Id
    private String id;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String firstName;

    @Column(length = 10, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate registeredDate;

    @Builder
    public Users(String id, String password, String firstName, String lastName, LocalDate registeredDate) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredDate = registeredDate;
    }
}
