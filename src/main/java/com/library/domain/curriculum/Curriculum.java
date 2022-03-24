package com.library.domain.curriculum;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate regDate;

    @Builder
    public Curriculum(Long id, Long userId, String name, LocalDate regDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.regDate = regDate;
    }
}
