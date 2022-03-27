package com.library.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDate;

/*
 * 유저 엔티티
 */
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String loginId;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String firstName;

    @Column(length = 10, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate registeredDate;

    @Builder
    public Users(Long id, String loginId, String password, String firstName, String lastName, LocalDate registeredDate) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredDate = registeredDate;
    }
}
